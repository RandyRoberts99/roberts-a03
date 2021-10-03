/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.util.Scanner;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    private int getDifficulty(String input)
    {
        String userInput;
        int userInt = -1;

        while (userInt == -1)
        {
            System.out.print(input);
            userInput = reader.next();
            try
            {
                userInt = Integer.parseInt(userInput);
                if (userInt == 1 || userInt == 2 || userInt == 3)
                {
                    return userInt;
                }
                else
                {
                    System.out.println("Enter a valid number!");
                    userInt = -1;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Enter a valid number!");
                userInt = -1;
            }
        }
        return userInt;
    }
    private String getGuess(String guessResponse)
    {
        String userGuess = null;
        System.out.print(guessResponse);
        userGuess = reader.next();
        return userGuess;
    }
    private int checkGuess(String input)
    {
        int userInt = -1;
        try
        {
            userInt = Integer.parseInt(input);
            return userInt;
        }
        catch (NumberFormatException e)
        {
            userInt = -1;
        }
        return userInt;
    }
    private int setDifficulty(int difficulty)
    {
        int max = -1;

        if (difficulty == 1)
        {
            max = 10;
        }
        if (difficulty == 2)
        {
            max = 100;
        }
        if (difficulty == 3)
        {
            max = 1000;
        }
        return max;
    }
    private String checkUserGuessResponse(int userNumber, int guessNumber)
    {
        String guessResponse;
        if (userNumber > guessNumber)
        {
            guessResponse = "Too high. Guess again: ";
        }
        else if (userNumber < guessNumber && userNumber > -1)
        {
            guessResponse = "Too low. Guess again: ";
        }
        else
        {
            guessResponse = "Not a valid number. Guess again: ";
        }
        return guessResponse;
    }
    private String checkUserPlayResponse(String input)
    {
        boolean isCorrectResponse = false;
        String userInput = null;
        while (!isCorrectResponse)
        {
            System.out.print(input);
            userInput = reader.next();

            if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("n"))
            {
                isCorrectResponse = true;
            }
            else
            {
                System.out.print("Please enter 'Y' or 'N' to proceed!\n");
            }
        }
        return userInput;
    }
    private void playGuessingGame()
    {
        // ask the user if they would like to play again and repeat this process until the user enters "n"

        String userResponse = "Y";

        while (userResponse.equalsIgnoreCase("Y"))
        {
            // ask the user to enter a digit, 1-3 to determine the difficulty of their game.
            int difficulty = getDifficulty("Enter the difficulty level (1, 2, or 3): ");

            int max = setDifficulty(difficulty);

            int guessNumber = rand.nextInt(max);

            int numberOfGuesses = 1;

            int userNumber = -1;

            String guessResponse = "I have my number. What's your guess? ";

            String userGuess = getGuess(guessResponse);

            userNumber = checkGuess(userGuess);

            // compare the number to the actual number until the user guesses correctly
            while (userNumber != guessNumber)
            {
                numberOfGuesses++;

                guessResponse = checkUserGuessResponse(userNumber, guessNumber);

                userGuess = getGuess(guessResponse);

                userNumber = checkGuess(userGuess);
            }
            System.out.print("You got it in " + numberOfGuesses + " guesses!\n\n");

            userResponse = checkUserPlayResponse("Do you wish to play again (Y/N)? ");
        }
    }
    @Test
    private void testSetDifficulty()
    {
        int difficulty = setDifficulty(2);
        assertEquals(100, difficulty);
    }
}