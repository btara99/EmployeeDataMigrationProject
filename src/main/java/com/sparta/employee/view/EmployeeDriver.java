package com.sparta.employee.view;

import com.sparta.employee.controller.EmployeeInfo;
import com.sparta.employee.controller.JDBCManager;
import com.sparta.employee.model.CleaningManager;

import java.util.ArrayList;
import java.util.HashSet;

public class EmployeeDriver {
    public static ArrayList<EmployeeInfo> employeesUnique = new ArrayList<>(); // Arraylist to store all unique records
    public static ArrayList<EmployeeInfo> employeesDuplicates = new ArrayList<>(); // Arraylist to store all duplicate records
    public static HashSet<Integer> idCheck = new HashSet<>(); // Hashset cannot contain dupes

    public static void main(String[] args) {

        CleaningManager cleaningManager = new CleaningManager();
        JDBCManager jbdcManager = new JDBCManager();

        Thread t1 = new Thread(cleaningManager);
        t1.start();

        Thread t2 = new Thread(jbdcManager);
        t2.start();

        //cleaningManager.fileCleaner();
        //jbdcManager.databaseHandling();


    }
}



