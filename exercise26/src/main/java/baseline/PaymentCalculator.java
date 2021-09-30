/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

public class PaymentCalculator
{
    private double balance;
    private double APR;
    private double i;
    private double monthlyPayment;

    public PaymentCalculator(double balance, double APR, double monthlyPayment)
    {
        this.balance = Math.ceil(balance);
        this.APR = APR;
        this.monthlyPayment = Math.ceil(monthlyPayment);

        i = APR / 36500.0;
    }
    public int calculateMonthsUntilPaidOff()
    {
        double numMonths = (-1.0/30.0) * Math.log(1 + ((balance/monthlyPayment) * (1.0 - (Math.pow((1 + i), 30.0)))))/Math.log(1.0 + i);

        int numMonthsInt = (int)(Math.ceil(numMonths));

        return numMonthsInt;
    }
}