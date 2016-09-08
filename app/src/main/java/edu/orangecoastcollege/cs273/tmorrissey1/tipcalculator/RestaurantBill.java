package edu.orangecoastcollege.cs273.tmorrissey1.tipcalculator;

/**
 * Created by tmorrissey1 on 9/8/2016.
 */
public class RestaurantBill {

    private double mAmount;
    private double mTipPercent;
    private double mTipAmount;
    private double mTotalAmount;

    public RestaurantBill(double amount, double TipPercent) {
        this.mAmount = amount;
        this.mTipPercent = TipPercent;
        recalculateAmounts();
    }

    public RestaurantBill() {
        mTipAmount = 0.0;
        mAmount = 0.0;
        mTotalAmount = 0.0;
        mTipPercent = 0.0;
    }

    public double getAmount() {
        return mAmount;
    }

    public void setAmount(double mAmount) {
        this.mAmount = mAmount;
        recalculateAmounts();
    }

    public double getTipPercent() {
        return mTipPercent;
    }

    public void setTipPercent(double mTipPercent) {
        this.mTipPercent = mTipPercent;
        recalculateAmounts();
    }

    public double getTipAmount() {
        return mTipAmount;
    }

    public double getTotalAmount() {
        return mTotalAmount;
    }

    private void recalculateAmounts() {
        mTipAmount = mAmount * mTipPercent;
        mTotalAmount = mAmount + mTipAmount;
    }

}
