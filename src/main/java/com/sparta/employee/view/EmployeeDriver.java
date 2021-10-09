package com.sparta.employee.view;

import com.sparta.employee.controller.*;
import com.sparta.employee.controller.JDBCMultiThread.JDBCMultiThreadInsert;
import com.sparta.employee.controller.JDBCMultiThread.JDBCMultiThreadInsert2;
import com.sparta.employee.controller.JDBCMultiThread.JDBCMultiThreadTableHandle;
import com.sparta.employee.logging.LoggingManager;
import com.sparta.employee.model.CleaningManager;
import com.sparta.employee.model.EmployeeDAOConcrete;
import com.sparta.employee.model.EmployeeDAOInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.function.Consumer;

import static java.lang.System.in;


public class EmployeeDriver {

    static LoggingManager loggingManager = new LoggingManager();
    public static ArrayList<EmployeeDAOInfo> employeesUnique = new ArrayList<>(); // Arraylist to store all unique records
    public static ArrayList<EmployeeDAOInfo> employeesUniqueSplit = new ArrayList<>(); // Arraylist to store half the records
    public static ArrayList<EmployeeDAOInfo> employeesUniqueSplit2 = new ArrayList<>(); // Arraylist to store other half of the records
    public static ArrayList<EmployeeDAOInfo> employeesDuplicates = new ArrayList<>(); // Arraylist to store all duplicate records
    public static HashSet<Integer> idCheck = new HashSet<>(); // Hashset cannot contain dupes


    private static class MyPrinter implements Consumer<String> {

        @Override
        public void accept(String s) {
            System.out.println(s);
        }
    }

    public static void multiThread() throws InterruptedException {
        CleaningManager cleaningManager = new CleaningManager();
        JDBCMultiThreadTableHandle jdbcMangerMultiThread = new JDBCMultiThreadTableHandle();
        JDBCMultiThreadInsert jdbcMultiThreadInsert = new JDBCMultiThreadInsert();
        JDBCMultiThreadInsert2 jdbcMultiThreadInsert2 = new JDBCMultiThreadInsert2();

        Thread cleaningThread = new Thread(cleaningManager);
        Thread multiThreadTable = new Thread(jdbcMangerMultiThread);
        Thread multiThreadInsertion1 = new Thread(jdbcMultiThreadInsert);
        Thread multiThreadInsertion2 = new Thread(jdbcMultiThreadInsert2);
        //MULTI THREAD
        cleaningThread.start();
        cleaningThread.join();


        for(int i = 0 ; i < employeesUnique.size()/2; i++){
            employeesUniqueSplit.add(employeesUnique.get(i));
        }

        for(int i = employeesUnique.size()/2; i < employeesUnique.size(); i++){
            employeesUniqueSplit2.add(employeesUnique.get(i));
        }

        multiThreadTable.start();
        multiThreadTable.join();
        double startTime = System.nanoTime(); //starts the timer just before inserting into database
        multiThreadInsertion1.start();
        multiThreadInsertion2.start();
        multiThreadInsertion1.join();
        multiThreadInsertion2.join();
        double finalTime = (System.nanoTime() - startTime) / 1000000000; //ends the timer just inserting into database
        System.out.println("Time taken to populate database using multi threading: " + finalTime + " seconds");
        loggingManager.timeLogMultiThread(finalTime);
    }

    public static void main(String[] args) throws InterruptedException {
        DisplayManger displayManger = new DisplayManger();

        CleaningManager cleaningManager = new CleaningManager();
        JDBCSingleThread jdbcSingleThread = new JDBCSingleThread();
        EmployeeDAOInterface employeeDAOInterface = new EmployeeDAOConcrete();
        Boolean status = true;
        boolean newStatus = true;


        while(status){
            System.out.println(displayManger.getDisplayThreads());
            try{
                Scanner scanner = new Scanner(in);
                int threadType = Integer.parseInt(scanner.next());
                switch(threadType){
                    case 1:
                        //SINGLE THREAD
                        cleaningManager.fileCleaner();
                        jdbcSingleThread.databaseHandling();
                        status = false;
                        break;

                    case 2:
                        //MULTI THREAD
                        multiThread();
                        status = false;
                        break;

                    default:
                        System.err.println("Incorrect range please choose 1 or 2");
                }

            } catch (NumberFormatException e) {
                loggingManager.normalException(e);
                e.printStackTrace();
            }

        }

        while(newStatus){
            System.out.println(displayManger.getDisplaySQLStatements());
            try{
                Scanner scanner = new Scanner(in);
                int sqlType = Integer.parseInt(scanner.next());
                switch(sqlType){
                    case 1:
                        employeeDAOInterface.get100Employees();
                        break;
                    case 2:
                        employeeDAOInterface.getHighestSalary();
                        break;
                    case 3:
                        employeeDAOInterface.getOldestEmployees();
                        break;
                    case 4:
                        employeeDAOInterface.getRecentEmployees();
                        break;
                    case 5:
                        employeeDAOInterface.getFemaleEmployees();
                        break;
                    case 6:
                        employeeDAOInterface.getSalaryAbove5figures();
                        break;
                    case 7:
                        System.out.println("Exiting");
                        newStatus = false;
                        break;

                    default:
                        System.err.println("Incorrect range please choose  a num between 1-7");
                }

            } catch (NumberFormatException e) {
                loggingManager.normalException(e);
                e.printStackTrace();
            }

        }


    }
}




