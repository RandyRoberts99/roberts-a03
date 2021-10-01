/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

import java.util.Arrays;
import java.util.Scanner;

public class Solution24
{
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {

        Solution24 solution = new Solution24();

        System.out.println("Enter two strings and I'll tell you if they are anagrams: ");

        // Take user input 1
        String strOne = solution.getString("Enter the first string: ");

        // Take user input 2
        String strTwo = solution.getString("Enter the second string: ");

        // Check if they are anagrams (private bool isAnagram)
        boolean isAnagram = solution.isAnagram(strOne, strTwo);

        // Output according to the boolean
        solution.printOutput(isAnagram, strOne, strTwo);
    }
    private String getString(String prompt)
    {
        String userResponse;
        System.out.print(prompt);
        userResponse = reader.nextLine();
        return userResponse;
    }
    private boolean isAnagram(String strOne, String strTwo)
    {
        boolean isAnagram;
        char[] strOneCharArray = strOne.toCharArray();
        char[] strTwoCharArray = strTwo.toCharArray();

        Arrays.sort(strOneCharArray);
        Arrays.sort(strTwoCharArray);

        strOne = Arrays.toString(strOneCharArray);
        strTwo = Arrays.toString(strTwoCharArray);

        if (strOne.equalsIgnoreCase(strTwo))
        {
            isAnagram = true;
        }
        else
        {
            isAnagram = false;
        }
        return isAnagram;
    }
    private void printOutput(boolean isAnagram, String strOne, String strTwo)
    {
        if (isAnagram)
        {
            System.out.print("\""+ strOne +"\" and \""+ strTwo +"\" are anagrams.");
        }
        else
        {
            System.out.print("\"" + strOne + "\" and \"" + strTwo + "\" are not anagrams.");
        }
    }
}