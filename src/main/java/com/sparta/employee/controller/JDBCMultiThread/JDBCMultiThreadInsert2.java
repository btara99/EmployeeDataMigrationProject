package com.sparta.employee.controller.JDBCMultiThread;

import com.sparta.employee.model.EmployeeDAOInfo;
import com.sparta.employee.view.EmployeeDriver;

import java.sql.*;

public class JDBCMultiThreadInsert2 extends EmployeeDriver implements Runnable{

        public void dbInsertionThread2() {

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees", "root", "Password321@")) {
                conn.setAutoCommit(false); // grouping multiple subsequent statements in one
                Statement statement = conn.createStatement();
                PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO employees(EmpID,Name_Prefix,First_Name,Middle_Initial," +
                        "Last_Name,Gender,Email,DOB,DOJ,Salary)VALUES (?,?,?,?,?,?,?,?,?,?)");


                for (EmployeeDAOInfo it : employeesUniqueSplit2) {  // Stores the values into the DB
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
                statement.close(); //don't close then reopen
                System.out.println("Thread 2 has populated its rows");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        }


    @Override
    public void run() {
        dbInsertionThread2();
    }
}

