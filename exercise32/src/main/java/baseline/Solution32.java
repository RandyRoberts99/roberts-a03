/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

import java.util.Scanner;
import java.util.Random;

public class Solution32
{
    private static final Scanner reader = new Scanner(System.in);
    private static final Random rand = new Random();

    public static void main(String[] args)
    {
        Solution32 solution = new Solution32();
        System.out.print("Let's play Guess the Number!\n\n");

        // start the game and wait for the user to enter a number
        // ask the user if they would like to play again and repeat this process until the user enters "n"
        // ask the user to enter a digit, 1-3 to determine the difficulty of their game.
        // compare the number to the actual number until the user guesses correctly
        solution.playGuessingGame();
    }

}