package baseline;

import org.junit.Test;

import java.util.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Solution39
{
    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args)
    {
        Solution39 solution = new Solution39();

        // Create a new list of maps and insert six employees into the list
        List<Map<String, String>> employeeList = new ArrayList<Map<String, String>>();

        Map<String,String> employee1 = solution.populateEmployee("John", "Johnson", "Manager", "2016-12-31");
        employeeList.add(0,employee1);

        Map<String,String> employee2 = solution.populateEmployee("Tou", "Xiong", "Software Engineer", "2016-10-05");
        employeeList.add(1,employee2);

        Map<String,String> employee3 = solution.populateEmployee("Michaela", "Michaelson", "District Manager", "2015-12-19");
        employeeList.add(2,employee3);

        Map<String,String> employee4 = solution.populateEmployee("Jake", "Jacobson", "Programmer", "");
        employeeList.add(3,employee4);

        Map<String,String> employee5 = solution.populateEmployee("Jacquelyn", "Jackson", "DBA", "");
        employeeList.add(4,employee5);

        Map<String,String> employee6 = solution.populateEmployee("Sally", "Webber", "Web Developer", "2015-12-18");
        employeeList.add(5,employee6);

        // Sort the employees by last name by getting their last name and using collections.sort
        solution.sortEmployees(employeeList);

        // print the newly sorted list of employees
        solution.printEmployeeList(employeeList);
    }
}

