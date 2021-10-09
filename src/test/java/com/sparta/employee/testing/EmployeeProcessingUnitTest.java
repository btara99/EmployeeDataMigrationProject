package com.sparta.employee.testing;

import com.sparta.employee.model.EmployeeProcessing;
import org.junit.jupiter.api.Test;


import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeProcessingUnitTest {

    @Test
    public void dateFormatTest() throws ParseException {
        EmployeeProcessing employeeProcessing = new EmployeeProcessing();
        String date = "9/21/1982";
        assertTrue(employeeProcessing.dateFormater(date).toString().equals("1982-09-21"));
    }

    @Test
    public void dateFormatTest2() throws ParseException {
        EmployeeProcessing employeeProcessing = new EmployeeProcessing();
        String date = "04/05/2001";
        assertTrue(employeeProcessing.dateFormater(date).toString().equals("2001-04-05"));
    }

    @Test
    public void idProcessingTest() throws ParseException {
        EmployeeProcessing employeeProcessing = new EmployeeProcessing();
        String test = "1,Mrs.,Lavon,A,Shufelt,F,lavon.shufelt@aol.com,12/19/1977,7/23/2000,184597";
        assertTrue(employeeProcessing.createEmployeeRow(test).getEmployeeID() == 1);
    }

    @Test
    public void titleProcessingTest() throws ParseException {
        EmployeeProcessing employeeProcessing = new EmployeeProcessing();
        String test = "1,Mrs.,Lavon,A,Shufelt,F,lavon.shufelt@aol.com,12/19/1977,7/23/2000,184597";
        assertTrue(employeeProcessing.createEmployeeRow(test).getNamePrefix().equals("Mrs."));
    }

    @Test
    public void firstnameProcessingTest() throws ParseException {
        EmployeeProcessing employeeProcessing = new EmployeeProcessing();
        String test = "1,Mrs.,Lavon,A,Shufelt,F,lavon.shufelt@aol.com,12/19/1977,7/23/2000,184597";
        assertTrue(employeeProcessing.createEmployeeRow(test).getFirstName().equals("Lavon"));
    }

    @Test
    public void middleNameProcessingTest() throws ParseException {
        EmployeeProcessing employeeProcessing = new EmployeeProcessing();
        String test = "1,Mrs.,Lavon,A,Shufelt,F,lavon.shufelt@aol.com,12/19/1977,7/23/2000,184597";
        assertTrue(employeeProcessing.createEmployeeRow(test).getMidInitial().equals("A"));
    }

    @Test
    public void lastNameProcessingTest() throws ParseException {
        EmployeeProcessing employeeProcessing = new EmployeeProcessing();
        String test = "1,Mrs.,Lavon,A,Shufelt,F,lavon.shufelt@aol.com,12/19/1977,7/23/2000,184597";
        assertTrue(employeeProcessing.createEmployeeRow(test).getLastName().equals("Shufelt"));
    }

    @Test
    public void emailProcessingTest() throws ParseException {
        EmployeeProcessing employeeProcessing = new EmployeeProcessing();
        String test = "1,Mrs.,Lavon,A,Shufelt,F,lavon.shufelt@aol.com,12/19/1977,7/23/2000,184597";
        assertTrue(employeeProcessing.createEmployeeRow(test).geteMail().equals("lavon.shufelt@aol.com"));
    }

    @Test
    public void salaryProcessingTest() throws ParseException {
        EmployeeProcessing employeeProcessing = new EmployeeProcessing();
        String test = "1,Mrs.,Lavon,A,Shufelt,F,lavon.shufelt@aol.com,12/19/1977,7/23/2000,184597";
        assertTrue(employeeProcessing.createEmployeeRow(test).getSalary() == 184597);
    }
}
