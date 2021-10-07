package com.sparta.employee.controller;

import java.sql.*;

public class JDBCManager {
    public void databaseHandling(){
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:employees.db") ){
            Statement statement = conn.createStatement();
            statement.executeUpdate("DROP TABLE employees");  //maybe check if table exist then drop (maybe remove rows)
            statement.executeUpdate("CREATE TABLE employees" +
                    "(EmpID int, Name_Prefix varchar(255)," +
                    "First_Name varchar(255), Middle_Initial " +
                    "varchar(255), Last_Name varchar(255)," +
                    "Gender varchar(1),Email varchar(255)," +
                    "DOB Date, DOJ Date, Salary INT(1000))");

            statement.close();


        }catch(SQLException sqle){
            sqle.printStackTrace();
            System.out.println("SQL exception");
        }
    }
}
