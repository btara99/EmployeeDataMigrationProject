package com.sparta.employee.model;

import com.sparta.employee.controller.EmployeeDAOInfo;
import com.sparta.employee.logging.LoggingManager;
import com.sparta.employee.view.EmployeeDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CleaningManager extends EmployeeDriver implements Runnable {
    LoggingManager loggingManager = new LoggingManager();
    String line = null; // initiates line

    public synchronized void fileCleaner(){
        try (BufferedReader in = new BufferedReader(new FileReader("EmployeeRecordsLarge.csv"))) {
            in.readLine(); // skips the first line
            double startTime = System.nanoTime(); // starts the timer for data processing
            while ((line = in.readLine()) != null) {
                try{
                    EmployeeDAOInfo employeeInfo = EmployeeProcessing.createEmployeeRow(line);
                    int currId = employeeInfo.getEmployeeID();
                    if(idCheck.add(currId) == false){
                        employeesDuplicates.add(employeeInfo);
                    }
                    else{
                        employeesUnique.add(employeeInfo);

                    }

                } catch (Exception exception) {
                    exception.printStackTrace();
                    loggingManager.normalException(exception);
                    System.out.println("Employee was not checked " + line);
                }
            }
            double finalTime = (System.nanoTime() - startTime)/1000000000;
            System.out.println("The number of unique entries: "+ employeesUnique.size());
            System.out.println("The number of duplicate entries: "+ employeesDuplicates.size());
            System.out.println("Time Taken to process: " + finalTime + " seconds");
            loggingManager.timeLogForCleaning(finalTime);


        } catch (FileNotFoundException fe){
            fe.printStackTrace();
            loggingManager.fileNotFound(fe);
            System.out.println("File is not found");
        } catch (IOException e) {
            e.printStackTrace();
            loggingManager.ioLog(e); // logging
            System.out.println("Input output exception");

        }
    }

    @Override
    public void run() {
        fileCleaner();
    }
}
