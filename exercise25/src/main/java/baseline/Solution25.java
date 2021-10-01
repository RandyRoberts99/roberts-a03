/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

import java.util.Scanner;

public class Solution25
{
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution25 solution = new Solution25();

        // prompt the user to enter a password
        String password = solution.getString("Enter your password: ");

        // determine the strength of a password through passwordValidator and returning an int that is the
        // score of said password, 1-4
        int passwordStrength = solution.passwordValidator(password);

        // create an output according to the integer
        String output = solution.checkPasswordStrength(passwordStrength, password);

        System.out.print(output);
    }
    private String getString(String prompt)
    {
        String userResponse;
        System.out.print(prompt);
        userResponse = reader.nextLine();
        return userResponse;
    }
    private int passwordValidator(String password)
    {
        //A very weak password contains only numbers and is fewer than eight characters.
        //A weak password contains only letters and is fewer than eight characters.
        //A strong password contains letters and at least one number and is at least eight characters.
        //A very strong password contains letters, numbers, and special characters and is at least eight characters.

        int passwordStrength = 0;
        try
        {
            Integer.parseInt(password);
            passwordStrength = 0;
        }
        catch (NumberFormatException e)
        {
            // password contains letters
            passwordStrength++;
        }
        // check password length
        if (password.length() >= 8)
        {
            // password >= 8
            passwordStrength++;

            int numSpecialCharacters = 0;
            // check for special characters
            for (int i = 0; i < password.length(); i++)
            {
                char c = password.charAt(i);
                if (!Character.isLetterOrDigit(c))
                {
                    numSpecialCharacters++;
                }
            }
            if (numSpecialCharacters > 0)
            {
                passwordStrength++;
            }
        }
        return passwordStrength;
    }
    private String checkPasswordStrength(int passwordStrength, String password)
    {
        String outputStatement = outputStatement = "The password '" + password + "' is a password of unknown strength.";
        if (passwordStrength == 0)
        {
            outputStatement = "The password '" + password + "' is a very weak password.";
        }
        if (passwordStrength == 1)
        {
            outputStatement = "The password '" + password + "' is a weak password.";
        }
        if (passwordStrength == 2)
        {
            outputStatement = "The password '" + password + "' is a strong password.";
        }
        if (passwordStrength == 3)
        {
            outputStatement = "The password '" + password + "' is a very strong password.";
        }
        return outputStatement;
    }
}