package com.sparta.employee.view;

import com.sparta.employee.controller.JDBCMultiThreadInsert2;
import com.sparta.employee.controller.EmployeeInfo;
import com.sparta.employee.controller.JDBCSingleThread;
import com.sparta.employee.controller.JDBCMangerMultiThread;
import com.sparta.employee.controller.JDBCMultiThreadInsert;
import com.sparta.employee.model.CleaningManager;

import java.util.ArrayList;
import java.util.HashSet;


public class EmployeeDriver {
    public static ArrayList<EmployeeInfo> employeesUnique = new ArrayList<>(); // Arraylist to store all unique records
    public static ArrayList<EmployeeInfo> employeesUniqueSplit = new ArrayList<>(); // Arraylist to store all unique records
    public static ArrayList<EmployeeInfo> employeesUniqueSplit2 = new ArrayList<>(); // Arraylist to store all unique records
    public static ArrayList<EmployeeInfo> employeesDuplicates = new ArrayList<>(); // Arraylist to store all duplicate records
    public static HashSet<Integer> idCheck = new HashSet<>(); // Hashset cannot contain dupes

    public static void main(String[] args) throws InterruptedException {

        CleaningManager cleaningManager = new CleaningManager();
        JDBCSingleThread jdbcSingleThread = new JDBCSingleThread();
        JDBCMangerMultiThread jdbcMangerMultiThread = new JDBCMangerMultiThread();
        JDBCMultiThreadInsert jdbcMultiThreadInsert = new JDBCMultiThreadInsert();
        JDBCMultiThreadInsert2 jdbcMultiThreadInsert2 = new JDBCMultiThreadInsert2();

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




    }
}



