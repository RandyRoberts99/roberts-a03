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
    private ArrayList<Integer> fillValues(ArrayList<Integer> values)
    {
        boolean notDone = true;
        int userInt;

        while (notDone)
        {
            System.out.print("Enter a number: ");
            String userInput = reader.next();
            if (userInput.equalsIgnoreCase("done"))
            {
                notDone = false;
            }
            else
            {
                try
                {
                    userInt = Integer.parseInt(userInput);
                    values.add(userInt);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Enter a valid number!");
                }
            }
        }
        return values;
    }
    private void printList(ArrayList<Integer> values)
    {
        System.out.print("Numbers: ");
        for (int i = 0; i < values.size(); i++)
        {
            System.out.print(values.get(i));
            if (i != values.size() - 1)
            {
                System.out.print(", ");
            }
        }
        System.out.print("\n");
    }
    private double getAverage(ArrayList<Integer> values)
    {
        double fullAverage = 0;
        for (int i = 0; i < values.size(); i++)
        {
            fullAverage += (double)values.get(i);
        }
        fullAverage /= values.size();
        System.out.printf("The Average is %1.1f\n", fullAverage);
        return fullAverage;
    }
    private int getMin(ArrayList<Integer> values)
    {
        int currMin = values.get(0);

        for (int i = 1; i < values.size(); i++)
        {
            if (currMin > values.get(i))
            {
                currMin = values.get(i);
            }
        }
        System.out.print("The minimum is " + currMin + "\n");

        return currMin;
    }
    private int getMax(ArrayList<Integer> values)
    {
        int currMax = values.get(0);

        for (int i = 1; i < values.size(); i++)
        {
            if (currMax < values.get(i))
            {
                currMax = values.get(i);
            }
        }
        System.out.print("The maximum is " + currMax + "\n");

        return currMax;
    }
    private double getStd(ArrayList<Integer>values, double average)
    {
        double sum = 0.0;
        double standardDeviation = 0.0;

        for(int i = 0; i < values.size(); i++)
        {
            sum += (double)(values.get(i));
        }
        double mean = sum/values.size();

        for(int i = 0; i < values.size(); i++)
        {
            standardDeviation += Math.pow(((double)(values.get(i))) - mean, 2);
        }
        double stdDeviation = Math.sqrt(standardDeviation/values.size());

        System.out.print("The standard deviation is " + String.format("%1.2f", stdDeviation));

        return stdDeviation;
    }
}