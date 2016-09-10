package edu.orangecoastcollege.cs273.tmorrissey1.tipcalculator;

/**
 * Represents a restaurant bill
 * Created by tmorrissey1 on 9/8/2016.
 */
public class RestaurantBill {
    /**
     * Decimal amount of this RestaurantBill before tip.
     */
    private double mAmount;
    /**
     * Tip percentage of this RestaurantBill in decimal form.
     */
    private double mTipPercent;
    /**
     * Tip amount of this RestaurantBill in decimal form.
     */
    private double mTipAmount;
    /**
     * Decimal amount of this RestaurantBill after tip.
     */
    private double mTotalAmount;

    /**
     * Constructor for RestaurantBill. Creates a new RestaurantBill with given amount and tip
     * percent.
     * @param amount This RestaurantBill's amount.
     * @param TipPercent percentage of tip.
     */
    public RestaurantBill(double amount, double TipPercent) {
        this.mAmount = amount;
        this.mTipPercent = TipPercent;
        recalculateAmounts();
    }

    /**
     * Default constructor for RestaurantBill.
     */
    public RestaurantBill() {
        mTipAmount = 0.0;
        mAmount = 0.0;
        mTotalAmount = 0.0;
        mTipPercent = 0.0;
    }

    /**
     * Gets the monetary amount of this RestaurantBill before the tip.
     * @return This RestaurantBill's amount before tip.
     */
    public double getAmount() {
        return mAmount;
    }

    /**
     * Sets the decimal amount of this RestaurantBill before tip.
     * @param mAmount New amount of this RestaurantBill.
     */
    public void setAmount(double mAmount) {
        this.mAmount = mAmount;
        recalculateAmounts();
    }

    /**
     * Gets the tip percentage of this RestaurantBill in decimal format.
     * @return Tip Percentage in decimal format of this RestaurantBill.
     */
    public double getTipPercent() {
        return mTipPercent;
    }

    /**
     * Sets the tip percentage of this RestaurantBill and recalculates both the tip amount and the
     * total amount.
     * @param mTipPercent Tip percentage of this RestaurantBill in decimal format.
     *                    (Example: 10% as 0.10).
     */
    public void setTipPercent(double mTipPercent) {
        this.mTipPercent = mTipPercent;
        recalculateAmounts();
    }

    /**
     * Gets the decimal amount of this RestaurantBill's tip.
     * @return decimal amount of this RestaurantBill's tip.
     */
    public double getTipAmount() {
        return mTipAmount;
    }

    /**
     * Gets the total amount of this RestaurantBill in decimal form.
     * @return Total amount of this RestaurantBill in decimal form.
     */
    public double getTotalAmount() {
        return mTotalAmount;
    }

    /**
     *  Recalculates this RestaurantBill's amounts of the tip and total.
     */
    private void recalculateAmounts() {
        mTipAmount = mAmount * mTipPercent;
        mTotalAmount = mAmount + mTipAmount;
    }

}
