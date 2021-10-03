/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution38
{
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution38 solution = new Solution38();

        // Ask the user to enter a list of numbers, take that list as a string array
        System.out.print("Enter a list of numbers, separated by spaces: ");
        String[] userInput = reader.nextLine().split(" ");

        // read each integer inside the string, use modulus to determine if it's even or odd, and then insert into a
        // list if it is even.
        ArrayList<Integer> evenNumbers = solution.filterEvenNumbers(userInput);

        // output the list
        solution.printEvenNumbers(evenNumbers);
    }
    private ArrayList<Integer> filterEvenNumbers(String[] userInput)
    {
        ArrayList<Integer> evenNumbers = new ArrayList<Integer>();

        for (int i = 0; i < userInput.length; i++)
        {
            try
            {
                int testNumber = Integer.parseInt(userInput[i]);

                if (testNumber % 2 == 0)
                {
                    evenNumbers.add(testNumber);
                }
            }
            catch (NumberFormatException e)
            {
                continue;
            }
        }
        return evenNumbers;
    }
    private void printEvenNumbers(ArrayList<Integer> evenNumbers)
    {
        System.out.print("The even numbers are");
        for (int i = 0; i < evenNumbers.size(); i++)
        {
            System.out.print(" " + evenNumbers.get(i));
        }
    }
}