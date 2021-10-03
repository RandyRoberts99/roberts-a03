/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentCalculator
{
    private double balance;
    private double apr;
    private double i;
    private double monthlyPayment;

    public PaymentCalculator(double balance, double apr, double monthlyPayment)
    {
        this.balance = Math.ceil(balance);
        this.apr = apr;
        this.monthlyPayment = Math.ceil(monthlyPayment);

        i = apr / 36500.0;
    }
    public int calculateMonthsUntilPaidOff()
    {
        double numMonths = (-1.0/30.0) * Math.log(1 + ((balance/monthlyPayment) * (1.0 - (Math.pow((1 + i), 30.0)))))/Math.log(1.0 + i);

        return (int)(Math.ceil(numMonths));
    }
    @Test
    private void testCalculateMonthsUntilPaidOff()
    {
        PaymentCalculator paymentCalculator = new PaymentCalculator(1, 1, 1);
        int numMonths = paymentCalculator.calculateMonthsUntilPaidOff();
        assertEquals(2, numMonths);
    }
}