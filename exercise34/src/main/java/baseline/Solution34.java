/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Randall Roberts
 */

package baseline;

import java.util.Scanner;

public class Solution34
{
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution34 solution = new Solution34();

        // create an array of predetermined size of 5 of employee names.
        String[] employeeNames = {"John Doe", "Jane Doe", "Tom Thompson", "Jimmy Johnson", "Gary Gaston"};

        // print the current list of employees
        System.out.print("There are " + employeeNames.length + " employees.\n");
        solution.printEmployeeList(employeeNames);

        // ask the user to pick a name from the list
        String userEmpChoice = solution.checkEmployeeChoice(employeeNames);

        // delete the users input from the list, and output the new list
        employeeNames = solution.deleteEmployeeFromList(userEmpChoice, employeeNames);

        System.out.print("There are " + (employeeNames.length - 1) + " employees.\n");

        // print the new list
        solution.printEmployeeList(employeeNames);
    }
    private void printEmployeeList(String[] employeeNames)
    {
        for (int i = 0; i < 5; i++)
        {
            if (employeeNames[i] == null)
            {
                continue;
            }
            else
            {
                System.out.print(employeeNames[i] + "\n");
            }
        }
    }
    private String checkEmployeeChoice(String[] employeeNames)
    {
        boolean notEmployee = true;
        String userEmpChoice = null;

        while (notEmployee)
        {
            System.out.print("\nPlease enter an employee to remove: ");
            userEmpChoice = reader.nextLine();

            for (int i = 0; i < 5; i++)
            {
                if (userEmpChoice.equalsIgnoreCase(employeeNames[i]))
                {
                    notEmployee = false;
                }
            }
            if (notEmployee)
            {
                System.out.print("\nPlease enter the proper name of an employee!");
            }
        }
        return userEmpChoice;
    }
    private String[] deleteEmployeeFromList(String userEmpChoice, String[] employeeNames)
    {
        for (int i = 0; i < 5; i++)
        {
            if (userEmpChoice.equalsIgnoreCase(employeeNames[i]))
            {
                employeeNames[i] = null;
            }
        }
        return employeeNames;
    }
}
