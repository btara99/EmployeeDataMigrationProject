package com.sparta.employee.view;

import com.sparta.employee.controller.EmployeeDisplay;
import com.sparta.employee.controller.EmployeeInfo;
import com.sparta.employee.controller.JDBCManager;
import com.sparta.employee.model.CleaningManager;

import java.util.ArrayList;
import java.util.HashSet;

public class EmployeeDriver {
    public static ArrayList<EmployeeInfo> employeesUnique = new ArrayList<EmployeeInfo>();
    public static ArrayList<EmployeeInfo> employeesDuplicates = new ArrayList<EmployeeInfo>();
    public static HashSet<Integer> idCheck = new HashSet<Integer>(); // Hashset cannot contain dupes

    public static void main(String[] args) {

        CleaningManager cleaningManager = new CleaningManager();
        EmployeeDisplay employeeDisplay = new EmployeeDisplay();
        JDBCManager jbdcManager = new JDBCManager();

        cleaningManager.fileCleaner();
        jbdcManager.databaseHandling();


    }
}



