/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

import java.util.Scanner;

public class Solution28
{
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution28 solution = new Solution28();

        // Prompt the user to enter five integers with a loop
        // Return the sum of all five integers by adding each integer in the loop to the sum.
        // Print the sum

        int sum = solution.getSumOfFive();

        System.out.print("The total is: " + sum + ".");
    }
    private int getSumOfFive()
    {
        int sum = 0;
        for (int i = 0; i < 5; i++)
        {
            System.out.print("Enter a number: ");
            sum += reader.nextInt();
        }
        return sum;
    }
}