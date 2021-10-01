/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
*/

package baseline;

import java.util.Random;
import java.util.Scanner;

public class Solution33
{
    private static final Scanner reader = new Scanner(System.in);
    private static final Random rand = new Random();

    public static void main(String[] args)
    {
        Solution33 solution = new Solution33();

        // Create an array of responses
        String[] questionResponses = {"Yes.", "No.", "Maybe.", "Ask again later."};

        // Prompt the user for a question and output a random response from the array
        System.out.print("What's your question? ");

        String userResponse = reader.nextLine();

        String randomResponse = solution.getResponse(questionResponses);

        // print the random response
        System.out.print(randomResponse);
    }

    private String getResponse(String [] questionResponse)
    {
        int responseIndex = rand.nextInt(4);
        return questionResponse[responseIndex];
    }
}