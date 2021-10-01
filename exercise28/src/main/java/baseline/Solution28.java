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
        int sum = solution.getSumOfFive();

        // Print the sum
        System.out.print("The total is: " + sum + ".");
    }
    private int getSumOfFive()
    {
        int sum = 0;
        for (int i = 0; i < 5; i++)
        {
            sum += getInt("Enter a number: ");
        }
        return sum;
    }
    private int getInt(String input)
    {
        boolean notNumber = true;
        String userInput;
        int userInt = 0;

        while (notNumber)
        {
            System.out.print(input);
            userInput = reader.next();
            try
            {
                userInt = Integer.parseInt(userInput);
                notNumber = false;
            }
            catch (NumberFormatException e)
            {
                System.out.println("Enter a valid number!");
                userInt = 0;
            }
        }
        return userInt;
    }
}