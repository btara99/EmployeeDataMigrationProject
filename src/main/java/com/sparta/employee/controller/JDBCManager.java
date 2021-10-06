package com.sparta.employee.controller;

import java.sql.*;

public class JDBCManager {
    Connection conn = null;
//MAKE A CLASS MAYBE THAT CREATS TABLE THEN 1 THEN WRITES IT TO A TABLE AND CALL IT IN THIS CLASS
    public void databaseHandling(){
        try(Connection conn = DriverManager.getConnection("jdbc:sqlite:employees.db") ){
            Statement statement = conn.createStatement();
            //statement.executeUpdate("DROP TABLE employees");  //Find a way to check if it exists then drop
            statement.executeUpdate("CREATE TABLE employees" +  //maybe have this in a another class so use mvc
                    "(EmpID int, Name_Prefix varchar(255)," +
                    "First_Name varchar(255), Middle_Initial " +
                    "varchar(255), Last_Name varchar(255)," +
                    "Gender varchar(1),Email varchar(255)," +
                    "DOB Date, DOJ Date, Salary INT(1000))");

//            ResultSet rs = statement.executeQuery("SELECT * FROM USERS");
//            while(rs.next()){
//                System.out.println("Name: " + rs.getString("FIRST_NAME"));
//            }
//            rs.close();  //closing in reverse order
            statement.close();


        }catch(SQLException sqle){
            sqle.printStackTrace();
            System.out.println("SQL exception");
        }
    }
}
