package com.sparta.employee.model;

import java.sql.Date;

public class EmployeeProcessing {

    public static void createEmployeeRow(String allEmployees) {

        String[] rowValue = allEmployees.split(",");

        int employeeID = Integer.parseInt(rowValue[0]); // converts ID to int
        String namePrefix = rowValue[1]; // keeps the prefix as a string
        String firstName = rowValue[2]; // keeps the first name as a string
        String midInitial = rowValue[3]; // keeps the middle as a string
        String lastname = rowValue[4]; // keeps the last name as a string
        String gender = rowValue[5]; // keeps the gender as a string
        String eMail = rowValue[6]; // keeps the email as a string
        Date dateOfBirth = dateFormat(rowValue[7]);// converts the date from a string to an SQL date obj
        Date dateOfJoin = dateFormat(rowValue[8]);// converts the date from a string to an SQL date obj
        int salary = Integer.parseInt(rowValue[9]);// converts the salary as an int

    }

    public static Date dateFormat(String date){ //ADD A TEST FOR THIS
        java.time.format.DateTimeFormatter df = java.time.format.DateTimeFormatter.ofPattern("M/d,yyyy");
        java.sql.Date dateFormatted = java.sql.Date.valueOf(date);

        return  dateFormatted;
    }

}
