/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

import java.util.Scanner;

public class Solution29
{
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution29 solution = new Solution29();

        // Implement a function that will try and catch and number format exceptions, until the user
        // enters a valid double. At that point, do a calculation to determine the final product, and print
        // the final product.

        double rateOfReturn = solution.checkDouble("What is the rate of return? ");
        solution.printOutput(rateOfReturn);
    }
    private double checkDouble(String input)
    {
        boolean notNumber = true;
        String userInput;
        double userDouble = 0;

        while (notNumber) {
            System.out.print(input);
            userInput = reader.next();
            try
            {
                userDouble = Double.parseDouble(userInput);
                if (userDouble == 0)
                {
                    System.out.println("Sorry, that is not a valid input.");
                }
                else
                {
                    notNumber = false;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Sorry, that is not a valid input.");
                userDouble = 0;
            }
        }
        return userDouble;
    }
    private void printOutput(double rateOfReturn)
    {
        System.out.print("It will take " + (int)(72.0/rateOfReturn) + " years to double your initial investment.");
    }
}