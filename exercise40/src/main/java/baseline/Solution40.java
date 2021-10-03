package baseline;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Solution40
{
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution40 solution = new Solution40();

        // Create a new list of maps and insert six employees into the list
        List<Map<String, String>> employeeList = new ArrayList<Map<String, String>>();

        Map<String, String> employee1 = solution.populateEmployee("John", "Johnson", "Manager", "2016-12-31");
        employeeList.add(0, employee1);

        Map<String, String> employee2 = solution.populateEmployee("Tou", "Xiong", "Software Engineer", "2016-10-05");
        employeeList.add(1, employee2);

        Map<String, String> employee3 = solution.populateEmployee("Michaela", "Michaelson", "District Manager", "2015-12-19");
        employeeList.add(2, employee3);

        Map<String, String> employee4 = solution.populateEmployee("Jake", "Jacobson", "Programmer", "");
        employeeList.add(3, employee4);

        Map<String, String> employee5 = solution.populateEmployee("Jacquelyn", "Jackson", "DBA", "");
        employeeList.add(4, employee5);

        Map<String, String> employee6 = solution.populateEmployee("Sally", "Webber", "Web Developer", "2015-12-18");
        employeeList.add(5, employee6);

        // Sort the employees by last name by getting their last name and using collections.sort
        solution.sortEmployees(employeeList);

        // Take in the users search input to use in the method
        System.out.print("Enter a search string: ");
        String userSearchInput = reader.nextLine();

        // print the employees that match the search keyword, if any
        solution.printApplicableEmployees(employeeList, userSearchInput);
    }
    private Map<String, String> populateEmployee(String firstName, String lastName, String position, String sepDate)
    {
        Map<String, String> employee = new HashMap<String, String>();

        employee.put("firstname", firstName);
        employee.put("lastname", lastName);
        employee.put("position", position);
        employee.put("sepdate", sepDate);

        return employee;
    }
    private List<Map<String, String>> sortEmployees(List<Map<String, String>> employeeList)
    {
        List<String> lastNameList = new ArrayList<String>();

        for (int i = 0; i < employeeList.size(); i++)
        {
            Map<String, String> employee = (Map<String, String>) employeeList.get(i);
            lastNameList.add(employee.get("lastname"));
        }
        Collections.sort(lastNameList);

        for (int i = 0; i < employeeList.size(); i++)
        {
            String currentLastName = lastNameList.get(i);
            for (int j = 0; j < employeeList.size(); j++)
            {
                Map<String, String> employee = (Map<String, String>) employeeList.get(j);
                if (employee.get("lastname").equalsIgnoreCase(currentLastName))
                {
                    Collections.swap(employeeList, i, j);
                }
            }
        }
        return employeeList;
    }
    private void printApplicableEmployees(List<Map<String, String>> employeeList, String userSearchInput)
    {
        System.out.print("Name                | Position          | Separation Date\n");
        System.out.print("--------------------|-------------------|----------------\n");
        for (int i = 0; i < employeeList.size(); i++)
        {
            Map<String, String> employee = (Map<String, String>) employeeList.get(i);

            boolean isValidEmployee = checkEmployee(employee, userSearchInput);
            if (isValidEmployee)
            {
                printEmployee(employee);
            }
        }
    }
    private void printEmployee(Map<String, String> employee)
    {
        String fullName = employee.get("firstname") + " " + employee.get("lastname");
        System.out.print(fullName);

        int numNameSpaces = 20 - fullName.length();
        for (int y = 0; y < numNameSpaces; y++)
        {
            System.out.print(" ");
        }

        System.out.print("| ");

        String position = employee.get("position");
        System.out.print(position);

        int numPositionSpaces = 18 - position.length();
        for (int z = 0; z < numPositionSpaces; z++)
        {
            System.out.print(" ");
        }
        System.out.print("| ");
        System.out.print(employee.get("sepdate") + "\n");
    }
    private boolean checkEmployee(Map<String, String> employee, String userSearchInput)
    {
        boolean isValidEmployee = false;

        if (employee.get("firstname").toLowerCase().contains(userSearchInput.toLowerCase()))
        {
            isValidEmployee = true;
        }
        if (employee.get("lastname").toLowerCase().contains(userSearchInput.toLowerCase()))
        {
            isValidEmployee = true;
        }
        return isValidEmployee;
    }
    @Test
    private void testEmployeeChecker(Map<String, String> employee, String userSearchInput)
    {
        boolean isValidEmployee = checkEmployee(employee, userSearchInput);
        assertEquals(false, isValidEmployee);
    }
}