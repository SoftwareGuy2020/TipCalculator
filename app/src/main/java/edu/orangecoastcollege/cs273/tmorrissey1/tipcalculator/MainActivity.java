package edu.orangecoastcollege.cs273.tmorrissey1.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Currency;
import java.util.Locale;

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
    private String currencySymbol = Currency.getInstance(Locale.getDefault()).getSymbol();
    private RestaurantBill currentBill = new RestaurantBill();


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
        currentBill.setTipPercent((double) percentSeekBar.getProgress() / 100.0);

        amountEditText.addTextChangedListener(amountTextChangeListener);
        percentSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentTextView.setText(Integer.toString(progress).concat("%"));
                currentBill.setTipPercent((double) progress / 100.0 );
                tipTextView.setText(String.format(Locale.getDefault(), "%s%.2f",
                        currencySymbol, currentBill.getTipAmount()));
                totalTextView.setText(String.format(Locale.getDefault(), "%s%.2f",
                        currencySymbol, currentBill.getTotalAmount()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Do nothing
            }
        });
    }

    private final TextWatcher amountTextChangeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            // do nothing
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            try {


                double amount = charSequence.length() > 0 ?
                        Double.parseDouble(charSequence.toString()) : 0.0;
                amount /= 100.0;

                currentBill.setAmount(amount);
                amountTextView.setText(String.format(Locale.getDefault(), "%s%.2f",
                       currencySymbol, currentBill.getAmount()));

                tipTextView.setText(String.format(Locale.getDefault(), "%s%.2f",
                        currencySymbol, currentBill.getTipAmount()));
                totalTextView.setText(String.format(Locale.getDefault(), "%s%.2f",
                        currencySymbol, currentBill.getTotalAmount()));


            } catch (NumberFormatException ex) {
                amountEditText.setText("");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // do nothing
        }
    };
}
