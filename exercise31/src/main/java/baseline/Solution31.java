/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

import java.util.Scanner;

public class Solution31
{
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution31 solution = new Solution31();
        // TargetHeartRate = (((220 − age) − restingHR) × intensity) + restingHR

        // Create a program that prompts for your age and your resting heart rate.
        // Use the Karvonen formula to determine the target heart rate based on a range of intensities from 55% to 95%.
        // Generate a table with the results as shown in the example output.
        // To do this, I will create a loop that will track the current intensity i'm at and calculate at that intensity
        // until I have reached the desired result of 95%.

        //double age = solution.getDouble("What is the age? ");
        //double restingHR = solution.getDouble("What is the resting heart rate? ");

        //solution.printKarvonenHeartRates(age, restingHR);
    }

}