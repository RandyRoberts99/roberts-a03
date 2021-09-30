/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

import java.util.Scanner;

public class Solution30
{
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution30 solution = new Solution30();

        // create a double for loop
        // inside the for loop multiply each iterator by each other, to get each result
        // print a number of spaces(depending on the result) and then add the result to your print
        // drop a newline everytime the outer loop has reached its end

        int multiple = 12;
        solution.returnMultiTable(multiple);
    }
    private void returnMultiTable(int multiple)
    {
        for (int x = 1; x < multiple + 1; x++)
        {
            for (int y = 1; y < multiple + 1; y++)
            {
                int product = x * y;
                int numSpaces = 5 - String.valueOf(product).length();
                for (int i = 0; i < numSpaces; i++)
                {
                    System.out.print(" ");
                }
                System.out.print(product);
            }
            if (x == multiple)
            {
                continue;
            }
            else
            {
                System.out.print("\n");
            }
        }
    }
}