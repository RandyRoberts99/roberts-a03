/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution36
{
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution36 solution = new Solution36();

        // Create an arraylist and store values inside the arraylist until the user enters "done" into the array
        ArrayList<Integer> values = new ArrayList<Integer>();

        values = solution.fillValues(values);

        // create multiple functions to get data to use in the output of the array (average, standard deviation, etc.)
        // output in the appropriate format.
        solution.printList(values);

        double average = solution.getAverage(values);

        int min = solution.getMin(values);

        int max = solution.getMax(values);

        double std = solution.getStd(values, average);
    }
    
}