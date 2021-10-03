/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Solution35
{
    private static final Scanner reader = new Scanner(System.in);
    private static final Random rand = new Random();

    public static void main(String[] args)
    {
        Solution35 solution = new Solution35();

        // ask the user for inputs to fill an array until the input is blank.
        ArrayList<String> names = new ArrayList<String>();

        // take a random index from the array afterwards.
        String winnerName = solution.getWinner(names);

        // output the random index.
        System.out.print("The winner is... " + winnerName + ".");
    }
    private String getWinner(ArrayList<String> names)
    {
        System.out.print("Enter a name: ");
        String userInput = reader.nextLine();
        while (!(userInput.equals("")))
        {
            names.add(userInput);
            System.out.print("Enter a name: ");
            userInput = reader.nextLine();
        }
        return getRandomName(names);
    }
    private String getRandomName(ArrayList<String> names)
    {
        int i = names.size();
        int randomWinnerIndex = rand.nextInt(i);
        return names.get(randomWinnerIndex);
    }
}