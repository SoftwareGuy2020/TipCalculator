package edu.orangecoastcollege.cs273.tmorrissey1.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * Controller for Tip Calculator.
 * Inflates the GUI, creates an instance of RestaurantBill, and
 * manages input/output of the Tip Calculator Application.
 */
public class MainActivity extends AppCompatActivity {

    private TextView amountTextView;
    private TextView percentTextView;
    private TextView tipTextView;
    private TextView totalTextView;
    private EditText amountEditText;
    private SeekBar percentSeekBar;
    private RestaurantBill currentBill = new RestaurantBill();
    private static NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private static NumberFormat percent = NumberFormat.getPercentInstance();

    /**
     * Perform initialization of all fragments and loaders.
     * @param savedInstanceState Last saved instance state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountTextView = (TextView) findViewById(R.id.amountTextView);
        percentTextView = (TextView) findViewById(R.id.percentTextView);
        tipTextView = (TextView) findViewById(R.id.tipTextView);
        totalTextView = (TextView) findViewById(R.id.totalTextView);
        amountEditText = (EditText) findViewById(R.id.amountEditText);
        percentSeekBar = (SeekBar) findViewById(R.id.percentSeekBar);

        // Sets the percentage of the RestaurantBill if it is not set.
        currentBill.setTipPercent(percentSeekBar.getProgress() / 100.0);

        amountEditText.addTextChangedListener(amountTextChangeListener);


        percentSeekBar.setOnSeekBarChangeListener(percentChangeListener);


    }

    private final TextWatcher amountTextChangeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // do nothing
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            try {

                double amount = charSequence.length() > 0
                        ? Double.parseDouble(charSequence.toString()) : 0.0;
                amount /= 100.0;

                currentBill.setAmount(amount);
                amountTextView.setText(currencyFormat.format(currentBill.getAmount()));
                updateViews();

            } catch (NumberFormatException ex) {
                amountEditText.setText("");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // do nothing
        }
    };

    /**
     * Anonymous class for tip percentage seek bar change event
     */
    private SeekBar.OnSeekBarChangeListener percentChangeListener = new SeekBar.OnSeekBarChangeListener(){
        /**
         * Updates RestaurantBill tip percentage and displays the changes to the GUI.
         * Called when tip percentage seek bar progress is changed.
         *
         * @param seekBar The tip percentage seek bar
         * @param progress The current progress value
         * @param fromUser Whether the input is from the user or not
         */
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            currentBill.setTipPercent(progress / 100.0 );
            percentTextView.setText(percent.format(currentBill.getTipPercent()));

            updateViews();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            // Do nothing
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // Do nothing
        }
    };


    /**
     * Updates the tip TextView and total TextView text output
     */
    private void updateViews() {
        tipTextView.setText(currencyFormat.format(currentBill.getTipAmount()));
        totalTextView.setText(currencyFormat.format(currentBill.getTotalAmount()));
    }
}
