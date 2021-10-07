package com.sparta.employee.view;

import com.sparta.employee.controller.EmployeeDisplay;
import com.sparta.employee.controller.JDBCManager;
import com.sparta.employee.model.CleaningManager;

public class EmployeeDriver {

    public static void main(String[] args) {
        CleaningManager cleaningManager = new CleaningManager();
//        EmployeeDisplay employeeDisplay = new EmployeeDisplay();
//        JDBCManager jbdcManager = new JDBCManager();
//
        cleaningManager.fileCleaner();
//        employeeDisplay.displayDataProcessing(cleaningManager.employeesDuplicates.size(),cleaningManager.allEmployees.size());
//        jbdcManager.databaseHandling();

    }
}



