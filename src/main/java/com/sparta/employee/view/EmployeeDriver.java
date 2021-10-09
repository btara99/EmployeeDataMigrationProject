package com.sparta.employee.view;

import com.sparta.employee.controller.*;
import com.sparta.employee.controller.JDBCMultiThread.JDBCMultiThreadInsert;
import com.sparta.employee.controller.JDBCMultiThread.JDBCMultiThreadInsert2;
import com.sparta.employee.controller.JDBCMultiThread.JDBCMultiThreadTableHandle;
import com.sparta.employee.model.CleaningManager;
import com.sparta.employee.model.EmployeeDAOConcrete;
import com.sparta.employee.model.EmployeeDAOInfo;

import java.util.ArrayList;
import java.util.HashSet;


public class EmployeeDriver {
    public static ArrayList<EmployeeDAOInfo> employeesUnique = new ArrayList<>(); // Arraylist to store all unique records
    public static ArrayList<EmployeeDAOInfo> employeesUniqueSplit = new ArrayList<>(); // Arraylist to store half the records
    public static ArrayList<EmployeeDAOInfo> employeesUniqueSplit2 = new ArrayList<>(); // Arraylist to store other half of the records
    public static ArrayList<EmployeeDAOInfo> employeesDuplicates = new ArrayList<>(); // Arraylist to store all duplicate records
    public static HashSet<Integer> idCheck = new HashSet<>(); // Hashset cannot contain dupes

    public static void main(String[] args) throws InterruptedException {

        CleaningManager cleaningManager = new CleaningManager();
        JDBCSingleThread jdbcSingleThread = new JDBCSingleThread();
        JDBCMultiThreadTableHandle jdbcMangerMultiThread = new JDBCMultiThreadTableHandle();
        JDBCMultiThreadInsert jdbcMultiThreadInsert = new JDBCMultiThreadInsert();
        JDBCMultiThreadInsert2 jdbcMultiThreadInsert2 = new JDBCMultiThreadInsert2();
        EmployeeDAOInterface employeeDAOInterface = new EmployeeDAOConcrete();


        Thread cleaningThread = new Thread(cleaningManager);
        Thread multiThreadTable = new Thread(jdbcMangerMultiThread);
        Thread multiThreadInsertion1 = new Thread(jdbcMultiThreadInsert);
        Thread multiThreadInsertion2 = new Thread(jdbcMultiThreadInsert2);


//        cleaningManager.fileCleaner();  //just these for single thread
//        jdbcSingleThread.databaseHandling();

        //MULTI THREAD under
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

//            employeeDAOInterface.get100Employees();
//            employeeDAOInterface.getHighestSalary();
//            employeeDAOInterface.getOldestEmployees();
//            employeeDAOInterface.getRecentEmployees();


    }
}



