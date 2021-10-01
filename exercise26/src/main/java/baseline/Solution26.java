/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

import java.util.Scanner;

public class Solution26
{
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution26 solution = new Solution26();

        // Take in the balance as a double
        double balance = solution.getDouble("What is your balance? ");

        // percentages can be written with decimal places, so double makes the most sense to use
        // Take in the APR as a double
        double APR = solution.getDouble("What is the APR on the card (as a percent)? ");

        // Take in the monthly payment as a double
        double monthlyPayment = solution.getDouble("What is the monthly payment you can make? ");

        // constructor of payment calculator
        PaymentCalculator paymentCalculator = new PaymentCalculator(balance, APR, monthlyPayment);

        // Output the number of months
        int numMonths = paymentCalculator.calculateMonthsUntilPaidOff();

        // print the number of months
        System.out.print("It will take you " + numMonths + " months to pay off this card.");
    }
    private double getDouble(String input)
    {
        boolean notNumber = true;
        String userInput;
        double userDouble = 0;

        while (notNumber)
        {
            System.out.print(input);
            userInput = reader.next();
            try
            {
                userDouble = Double.parseDouble(userInput);
                notNumber = false;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Enter a valid number!");
                userDouble = 0;
            }
        }
        return userDouble;
    }
}