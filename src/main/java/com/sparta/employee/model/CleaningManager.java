package com.sparta.employee.model;

import com.sparta.employee.controller.EmployeeInfo;
import com.sparta.employee.view.EmployeeDriver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class CleaningManager extends EmployeeDriver {

    public ArrayList<EmployeeInfo> employeesUnique = new ArrayList<EmployeeInfo>();
    public ArrayList<EmployeeInfo> employeesDuplicates = new ArrayList<EmployeeInfo>();
    public HashSet<Integer> idCheck = new HashSet<Integer>(); // Hashset cannot contain dupes
    String line = null; // initiates line


    public void fileCleaner(){
        try (BufferedReader in = new BufferedReader(new FileReader("EmployeeRecords.csv"))) {
            in.readLine(); // skips the first line
            double startTime = System.nanoTime(); // starts the timer for data processing
            while ((line = in.readLine()) != null) {
                try{
                    EmployeeInfo employeeInfo = EmployeeProcessing.createEmployeeRow(line);
                    int currId = employeeInfo.getEmployeeID();
                    if(idCheck.add(currId) == false){
                        employeesDuplicates.add(employeeInfo);
                    }
                    else{
                        employeesUnique.add(employeeInfo);
                    }


                } catch (Exception exception) {
                    //exception.printStackTrace();
                    //ADD LOGGER HERE
                    System.out.println("Employee was not checked " + line);
                }
            }
            double finalTime = (System.nanoTime() - startTime)/1000000000;
            System.out.println("The number of unique entries: "+employeesUnique.size());
            System.out.println("The number of duplicate entries: "+employeesDuplicates.size());
            System.out.println("Time Taken to process: " + finalTime + " seconds");


        } catch (FileNotFoundException fe){
            fe.printStackTrace();
            System.out.println("File is not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Input output exception");

        }
    }



}
