package com.sparta.employee.model.JDBCMultiThread;

import com.sparta.employee.logging.LoggingManager;
import com.sparta.employee.controller.EmployeeDAOInfo;
import com.sparta.employee.view.EmployeeDriver;

import java.sql.*;

public class JDBCMultiThreadInsert extends EmployeeDriver implements Runnable {

    LoggingManager loggingManager = new LoggingManager();

    public void dbInsertionThread1() {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees", "root", "Password321@")) {
            Statement statement = conn.createStatement();
            conn.setAutoCommit(false); // grouping multiple subsequent statements in one
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO employees(EmpID,Name_Prefix,First_Name,Middle_Initial," +
                    "Last_Name,Gender,Email,DOB,DOJ,Salary)VALUES (?,?,?,?,?,?,?,?,?,?)");

            for (EmployeeDAOInfo it : employeesUniqueSplit) {  // Stores the values into the DB
                preparedStatement.setInt(1, it.getEmployeeID());
                preparedStatement.setString(2, it.getNamePrefix());
                preparedStatement.setString(3, it.getFirstName());
                preparedStatement.setString(4, it.getMidInitial());
                preparedStatement.setString(5, it.getLastName());
                preparedStatement.setString(6, it.getGender());
                preparedStatement.setString(7, it.geteMail());
                preparedStatement.setDate(8, it.getDateOfBirth());
                preparedStatement.setDate(9, it.getDateOfJoin());
                preparedStatement.setInt(10, it.getSalary());

                preparedStatement.execute(); //executes the statement for populating the row

            }
            preparedStatement.close();
            conn.commit();
            statement.close();

            System.out.println("Thread 1 has populated its rows");

        } catch (SQLException throwable) {
            loggingManager.sqlExceptionLog(throwable);
            throwable.printStackTrace();
        }



    }

    @Override
    public void run() {
        dbInsertionThread1();
    }
}
