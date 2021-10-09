package com.sparta.employee.view;

import com.sparta.employee.JDBCMultiThread2;
import com.sparta.employee.controller.EmployeeInfo;
import com.sparta.employee.controller.JDBCManager;
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
        JDBCManager jbdcManager = new JDBCManager();
        JDBCMangerMultiThread jdbcMangerMultiThread = new JDBCMangerMultiThread();
        JDBCMultiThreadInsert jdbcMultiThreadInsert = new JDBCMultiThreadInsert();
        JDBCMultiThread2 jdbcMultiThread2 = new JDBCMultiThread2();

        Thread t1 = new Thread(cleaningManager);
        Thread t2 = new Thread(jbdcManager);

        Thread t3 = new Thread(jdbcMangerMultiThread);
        Thread t4 = new Thread(jdbcMultiThreadInsert);
        Thread t5 = new Thread(jdbcMultiThread2);


        cleaningManager.fileCleaner();  //just these for single thread
        jbdcManager.databaseHandling();

        //MULTI THREAD under
//        t1.start();
//        t1.join();
//
//        for(int i = 0 ; i < employeesUnique.size()/2; i++){
//            employeesUniqueSplit.add(employeesUnique.get(i));
//        }
//
//        for(int i = employeesUnique.size()/2; i < employeesUnique.size(); i++){
//            employeesUniqueSplit2.add(employeesUnique.get(i));
//        }
//
//
//
//            t3.start();
//            t3.join();
//            double startTime = System.nanoTime(); //starts the timer just before inserting into database
//            t4.start();
//            t5.start();
//            t4.join();
//            t5.join();
//            double finalTime = (System.nanoTime() - startTime) / 1000000000; //ends the timer just inserting into database
//            System.out.println("Time taken to populate database using multi threading: " + finalTime + " seconds");




    }
}



