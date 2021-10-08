package com.sparta.employee.controller;

import java.sql.*;

public class JDBCManager {
    public void databaseHandling(){
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees","root","Password321@") ){
            Statement statement = conn.createStatement();
            statement.executeUpdate("DROP TABLE employees");  //DROPs table before any
            statement.executeUpdate("CREATE TABLE employees" +
                    "(EmpID int, Name_Prefix varchar(255)," +
                    "First_Name varchar(255), Middle_Initial " +
                    "varchar(255), Last_Name varchar(255)," +
                    "Gender varchar(2),Email varchar(255)," +
                    "DOB Date, DOJ Date, Salary INT(255))");

            conn.setAutoCommit(false); // doesn't commit straightaway
            //statement.close(); //don't close then reopen
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO employees(EmpID,Name_Prefix,First_Name,Middle_Initial," +
                            "Last_Name,Gender,Email,DOB,DOJ,Salary)VALUES (?,?,?,?,?,?,?,?,?,?)");

            //GO THROUGH LIST OF EMPLOYEES
            //MAP EACH EMPLOYEE INFO INTO THE CORRECT COLUMN
            // RECORD THE TIME TAKEN
            // MAKE SURE VALID CONNECTIONS ARE CLOSED IN REVERSE ORDER OF CREATION

        }catch(SQLException sqle){
            sqle.printStackTrace();
            System.out.println("SQL exception");
        }
    }
}
