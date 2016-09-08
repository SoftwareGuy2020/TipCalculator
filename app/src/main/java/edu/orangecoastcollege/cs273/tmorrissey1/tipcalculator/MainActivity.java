package edu.orangecoastcollege.cs273.tmorrissey1.tipcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView amountTextView;
    private TextView percentTextView;
    private TextView tipTextView;
    private TextView totalTextView;
    private EditText amountEditText;
    private SeekBar percentSeekBar;

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

        amountEditText.addTextChangedListener(amountTextChangeListener);
    }

    private final TextWatcher amountTextChangeListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            try {
                double amount = Double.parseDouble(charSequence.toString());
                amount /= 100;
                currentBill.setAmount(amount);
                amountTextView.setText(Double.toString(currentBill.getAmount()));

            }
            catch (NumberFormatException ex) {
                amountEditText.setText("");
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // do nothing
        }
    };
}
