/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution27
{
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution27 solution = new Solution27();

        // Take a first name
        // Take a last name
        // Take a zip code
        // Enter the employee ID
        String firstName = solution.getString("Enter the first name: ");

        String lastName = solution.getString("Enter the last name: ");

        String zipCode = solution.getString("Enter the ZIP code: ");

        String employeeID = solution.getString("Enter the employee ID: ");

        // Check each string entered, validate each one and concatenate into one string
        String finalResponse = solution.validateInput(firstName, lastName, zipCode, employeeID);

        // output that string
        System.out.print(finalResponse);
    }
    private String getString(String prompt)
    {
        String userResponse;
        System.out.print(prompt);
        userResponse = reader.nextLine();
        return userResponse;
    }
    private String checkFirstNameResponse(String name)
    {
        String firstNameResponse = "";
        if (name.length() < 2)
        {
            firstNameResponse = "The first name must be at least 2 characters long.\n";
            if (name.equalsIgnoreCase(""))
            {
                firstNameResponse += "The first name must be filled in.\n";
            }
        }
        return firstNameResponse;
    }
    private String checkLastNameResponse(String name)
    {
        String lastNameResponse = "";
        if (name.length() < 2)
        {
            lastNameResponse = "The last name must be at least 2 characters long.\n";
            if (name.equalsIgnoreCase(""))
            {
                lastNameResponse += "The last name must be filled in.\n";
            }
        }
        return lastNameResponse;
    }
    private String checkZipCode(String zipCode)
    {
        String zipCodeResponse;
        try
        {
            Integer.parseInt(zipCode);

            if (zipCode.length() == 5)
            {
                zipCodeResponse = "";
            }
            else
            {
                zipCodeResponse = "The zipcode must be a 5 digit number.\n";
            }
        }
        catch (NumberFormatException e)
        {
            zipCodeResponse = "The zipcode must be a 5 digit number.\n";
        }
        return zipCodeResponse;
    }
    private String checkEmpID(String employeeID)
    {
        String employeeIDResponse;

        if (employeeID.matches("\\D{2}-\\d{4}"))
        {
            employeeIDResponse = "";
        }
        else
        {
            employeeIDResponse = "The employee ID must be in the format of AA-1234.\n";
        }
        return employeeIDResponse;
    }
    private String validateInput(String firstName, String lastName, String zipCode, String employeeID)
    {
        String firstNameResponse = checkFirstNameResponse(firstName);

        String lastNameResponse = checkLastNameResponse(lastName);

        String zipCodeResponse = checkZipCode(zipCode);

        String employeeIDResponse = checkEmpID(employeeID);

        String finalResponse = (firstNameResponse + lastNameResponse + zipCodeResponse + employeeIDResponse);

        if (finalResponse.length() == 0)
        {
            finalResponse = "There were no errors found.";
        }
        return finalResponse;
    }
    @Test
    private void testEmpId(String employeeID)
    {
        String empID = checkEmpID("Test String");

        assertEquals("The employee ID must be in the format of AA-1234.\n", empID);
    }
}