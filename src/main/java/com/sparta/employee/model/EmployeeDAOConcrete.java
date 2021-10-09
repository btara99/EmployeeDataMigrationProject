package com.sparta.employee.model;

import com.sparta.employee.controller.EmployeeDAOInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.stream.Stream;

public class EmployeeDAOConcrete implements EmployeeDAOInterface {

    @Override
    public void get100Employees() {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees", "root", "Password321@")){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employees LIMIT 100");
            while(rs.next()){
                System.out.println("Employee ID: "+ rs.getString(1)+ " "+
                        "Name Prefix: "+ rs.getString(2)+ " " +
                        "First name: "+ rs.getString(3)+ " " +
                        "Middle Intial: "+ rs.getString(4)+ " " +
                        "Last name: "+ rs.getString(5)+" " +
                        "Gender: "+ rs.getString(6)+ " " +
                        "Email: "+ rs.getString(7)+ " " +
                        "DOB: "+ rs.getString(8)+ " " +
                        "DOJ: "+ rs.getString(9)+ " " +
                        "Salaray: "+ rs.getString(10)
                );
            }

            rs.close();
            statement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            //add logger

        }
    }

    @Override
    public void getHighestSalary() {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees", "root", "Password321@")){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employees ORDER BY Salary DESC LIMIT 10");
            while(rs.next()){
                System.out.println("Employee ID: "+ rs.getString(1)+ " "+
                        "First name: "+ rs.getString(3)+ " " +
                        "Last name: "+ rs.getString(5)+" " +
                        "Salary: "+ rs.getString(10)
                );
            }

            rs.close();
            statement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            //add logger

        }
    }

    @Override
    public void getOldestEmployees() {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees", "root", "Password321@")){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employees ORDER BY DOB DESC LIMIT 10");
            while(rs.next()){
                System.out.println("Employee ID: "+ rs.getString(1)+ " "+
                        "Name Prefix: "+ rs.getString(2)+ " " +
                        "First name: "+ rs.getString(3)+ " " +
                        "Last name: "+ rs.getString(5)+" " +
                        "Gender: "+ rs.getString(6)+ " " +
                        "DOB: "+ rs.getString(8)+ " " +
                        "DOJ: "+ rs.getString(9)+ " "

                );
            }

            rs.close();
            statement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            //add logger

        }
    }

    @Override
    public void getRecentEmployees() {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myemployees", "root", "Password321@")){
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employees ORDER BY DOJ DESC LIMIT 10");
            while(rs.next()){
                System.out.println("Employee ID: "+ rs.getString(1)+ " "+
                        "Name Prefix: "+ rs.getString(2)+ " " +
                        "First name: "+ rs.getString(3)+ " " +
                        "Last name: "+ rs.getString(5)+" " +
                        "Gender: "+ rs.getString(6)+ " " +
                        "DOB: "+ rs.getString(8)+ " " +
                        "DOJ: "+ rs.getString(9)+ " "
                );
            }

            rs.close();
            statement.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            //add logger

        }
    }

    @Override
    public void getFemaleEmployees() {
        //using lambda and stream to find female employees
        try (Stream<String> theStream = Files.lines(Paths.get("EmployeeRecordsLarge.csv"))) {
            theStream.filter(s -> s.split(",")[5].equals("F"))
                    .forEach(s -> System.out.println(s));

        } catch (IOException e) {
            //add log
            e.printStackTrace();
        }

    }

    @Override
    public void getSalaryAbove5figures() {
        //using lambda and stream to find salary above 5 figures
        try (Stream<String> theStream = Files.lines(Paths.get("EmployeeRecordsLarge.csv"))) {
            theStream.filter(s -> s.split(",")[9].length()>5)
                    .forEach(s -> System.out.println(s));

        } catch (IOException e) {
            //add log
            e.printStackTrace();
        }
    }
}
