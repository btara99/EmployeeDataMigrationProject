package com.sparta.employee.model;

import com.sparta.employee.controller.EmployeeInfo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeProcessing {

    public static EmployeeInfo createEmployeeRow(String employeeRow) throws ParseException {

        String[] rowValue = employeeRow.split(",");

        int employeeID = Integer.parseInt(rowValue[0]); // converts ID to int
        String namePrefix = rowValue[1]; // keeps the prefix as a string
        String firstName = rowValue[2]; // keeps the first name as a string
        String midInitial = rowValue[3]; // keeps the middle as a string
        String lastname = rowValue[4]; // keeps the last name as a string
        String gender = rowValue[5]; // keeps the gender as a string
        String eMail = rowValue[6]; // keeps the email as a string
        Date dateOfBirth = dateFormater(rowValue[7]);// converts the date from a string to an SQL date obj
        Date dateOfJoin = dateFormater(rowValue[8]);// converts the date from a string to an SQL date obj
        int salary = Integer.parseInt(rowValue[9]);// converts the salary as an int

        return new EmployeeInfo(employeeID,namePrefix,firstName,midInitial,lastname,gender,eMail,dateOfBirth,dateOfJoin,salary);

    }

    //Converts the date from a string to java.sql format
    public static Date dateFormater(String date) throws ParseException  {
        java.util.Date stringDate = new SimpleDateFormat("MM/dd/yyyy").parse(date);
        java.sql.Date dateFormatted = new java.sql.Date(stringDate.getTime());

            return  dateFormatted;
    }

}
