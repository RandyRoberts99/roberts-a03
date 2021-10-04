/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

import java.util.Random;
import java.util.Scanner;

public class Solution37
{
    private static final Scanner reader = new Scanner(System.in);

    private static final Random rand = new Random();

    private static final char[] alphabet = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ".toCharArray();
    private static final char[] numbers = "0123456789".toCharArray();
    private static final char[] specialCharacters = "!@#$%^&*".toCharArray();

    public static void main(String[] args)
    {
        Solution37 solution = new Solution37();
        //What's the minimum length? 8
        //How many special characters? 2
        //How many numbers? 2
        //Your password is aurn2$1s#

        // Write a program that takes in a password length, a number of special characters, and a number of numbers
        // Use these parameters to generate a password that meets the requirements of the user
        // output the password

        // Get a minimum length for a password
        int passwordLength = solution.getPasswordLength();
        int numNonCharacters = passwordLength / 2;

        // get a number of maximum numbers in password
        int maxSpecialCharacters = solution.getMaxSpecialCharacters(numNonCharacters);

        // subtract from the maximum
        numNonCharacters -= maxSpecialCharacters;

        // max special characters will be the remainder of num non characters minus max numbers.
        int maxNumbers = solution.getMaxNumbers(numNonCharacters);

        char[] password = new char[passwordLength + rand.nextInt(10)];

        // Add in the special characters/numbers first, then fill the remaining indexes in the array with random letters
        solution.constructPassword(password, maxSpecialCharacters, maxNumbers);

        // convert the final array to a string
        String passwordStr = solution.getPasswordString(password);

        // output the result
        System.out.print("Your password is " + passwordStr);
    }
    private int getPasswordLength()
    {
        boolean notNumber = true;
        String userInput = null;
        int userInt = -1;
        while (notNumber)
        {
            System.out.print("What's the minimum length? ");
            userInput = reader.next();
            try
            {
                userInt = Integer.parseInt(userInput);
                if ((userInt < 1))
                {
                    System.out.print("That's an invalid input! (Must be positive integer > 0)\n");
                    userInt = -1;
                }
                else
                {
                    notNumber = false;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.print("That's an invalid input!\n");
            }
        }
        return userInt;
    }
    private int getMaxSpecialCharacters(int numNonCharacters)
    {
        boolean notNumber = true;
        String userInput = null;
        int userInt = -1;
        while (notNumber)
        {
            System.out.print("How many special characters? ");
            userInput = reader.next();
            try
            {
                userInt = Integer.parseInt(userInput);
                if ((numNonCharacters - userInt < 1))
                {
                    System.out.print("That's an invalid input!(Must be smaller than half of the minimum length)\n");
                    userInt = -1;
                }
                else
                {
                    notNumber = false;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.print("That's an invalid input!\n");
            }
        }
        return userInt;
    }
    private int getMaxNumbers(int numNonCharacters)
    {
        boolean notNumber = true;
        String userInput = null;
        int userInt = -1;
        while (notNumber)
        {
            System.out.print("How many numbers? ");
            userInput = reader.next();
            try
            {
                userInt = Integer.parseInt(userInput);
                if ((numNonCharacters - userInt < 0))
                {
                    System.out.print("That's an invalid input! (Must be equal to or less than the number of special characters)\n");
                    userInt = -1;
                }
                else
                {
                    notNumber = false;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.print("That's an invalid input!\n");
            }
        }
        return userInt;
    }
    private char[] constructPassword(char[] password, int maxSpecialCharacters, int maxNumbers)
    {
        fillPasswordWithSpecialCharacters(password, maxSpecialCharacters);

        fillPasswordWithNumbers(password, maxNumbers);

        fillPasswordWithCharacters(password);

        return password;
    }
    private char[] fillPasswordWithSpecialCharacters(char[] password, int maxSpecialCharacters)
    {
        for (int i = 0; i < maxSpecialCharacters; i++)
        {
            boolean notFilled = true;
            char specialChar = specialCharacters[rand.nextInt(specialCharacters.length)];
            while (notFilled)
            {
                int randomIndex = rand.nextInt(password.length);
                if (password[randomIndex] == '\u0000')
                {
                    password[randomIndex] = specialChar;
                    notFilled = false;
                }
            }
        }
        return password;
    }
    private char[] fillPasswordWithNumbers(char[] password, int maxNumbers)
    {
        for (int i = 0; i < maxNumbers; i++)
        {
            boolean notFilled = true;
            char specialNumber = numbers[rand.nextInt(numbers.length)];
            while (notFilled)
            {
                int randomIndex = rand.nextInt(password.length);
                if (password[randomIndex] == '\u0000')
                {
                    password[randomIndex] = specialNumber;
                    notFilled = false;
                }
            }
        }
        return password;
    }
    private char[] fillPasswordWithCharacters(char[] password)
    {
        for (int i = 0; i < password.length; i++)
        {
            if (password[i] == '\u0000')
            {
                char randomLetter = alphabet[rand.nextInt(alphabet.length)];
                password[i] = randomLetter;
            }
        }
        return password;
    }
    private String getPasswordString(char[] password)
    {
        String passwordStr = "";
        for (int i = 0; i < password.length; i++)
        {
            passwordStr += password[i];
        }
        return passwordStr;
    }
}