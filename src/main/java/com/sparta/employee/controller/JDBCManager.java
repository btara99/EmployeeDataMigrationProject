package com.sparta.employee.controller;

import com.sparta.employee.model.CleaningManager;
import com.sparta.employee.view.EmployeeDriver;

import java.sql.*;

public class JDBCManager extends EmployeeDriver {

    CleaningManager cleaningManager = new CleaningManager();
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


            double startTime = System.nanoTime();
            for(EmployeeInfo it : employeesUnique){  // Stores the values into the DB
                preparedStatement.setInt(1,it.getEmployeeID());
                preparedStatement.setString(2,it.getNamePrefix());
                preparedStatement.setString(3,it.getFirstName());
                preparedStatement.setString(4,it.getMidInitial());
                preparedStatement.setString(5,it.getLastName());
                preparedStatement.setString(6,it.getGender());
                preparedStatement.setString(7,it.geteMail());
                preparedStatement.setDate(8,it.getDateOfBirth());
                preparedStatement.setDate(9,it.getDateOfJoin());
                preparedStatement.setInt(10,it.getSalary());

                preparedStatement.execute(); //executes the statement for populating the row

            }
            double finalTime = (System.nanoTime() - startTime)/1000000000;
            preparedStatement.close();
            conn.commit();

            System.out.println("The rows have been populated successfully");
            System.out.println("Time taken: " + finalTime + "seconds");

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
