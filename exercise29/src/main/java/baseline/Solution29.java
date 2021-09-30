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

    }
}