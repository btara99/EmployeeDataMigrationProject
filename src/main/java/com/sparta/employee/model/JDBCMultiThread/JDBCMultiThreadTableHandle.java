package com.sparta.employee.model.JDBCMultiThread;

import com.sparta.employee.logging.LoggingManager;
import com.sparta.employee.view.EmployeeDriver;

import java.sql.*;

public class JDBCMultiThreadTableHandle extends EmployeeDriver implements Runnable {
    LoggingManager loggingManager = new LoggingManager();

    public synchronized void databaseHandling() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees", "root", "Password321@")) {

            Statement statement = conn.createStatement();
            statement.executeUpdate("DROP TABLE employees");  //DROPs table before any other statements
            statement.executeUpdate("CREATE TABLE employees" +
                    "(EmpID int, Name_Prefix varchar(255)," +
                    "First_Name varchar(255), Middle_Initial " +
                    "varchar(255), Last_Name varchar(255)," +
                    "Gender varchar(2),Email varchar(255)," +
                    "DOB Date, DOJ Date, Salary INT(255))");


        } catch (SQLException sqle) {
            sqle.printStackTrace();
            loggingManager.sqlExceptionLog(sqle);
            System.out.println("SQL exception");
        }
    }



    @Override
    public void run() {
        databaseHandling();
    }
}

