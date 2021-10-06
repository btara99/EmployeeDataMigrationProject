package com.sparta.employee.model;

import com.sparta.employee.view.EmployeeDriver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CleaningManager extends EmployeeDriver {
    public ArrayList<String> allEmployees = new ArrayList<String>();
    public ArrayList<String> employeesDuplicates = new ArrayList<String>();
    String line = null;
    int dupeCount = 0;

    public void fileCleaner() {

        try (BufferedReader in = new BufferedReader(new FileReader("EmployeeRecords.csv"))) {
            while ((line = in.readLine()) != null) {
                allEmployees.add(line);
            }
            //Used for removing any duplicate values by iterating through the array list and comparing
            for (int i = 1; i < allEmployees.size(); i++) {
                for (int j = i + 1; j < allEmployees.size(); j++) {
                    if (allEmployees.get(i).substring(0, 6).equals(allEmployees.get(j).substring(0, 6))) {
                        dupeCount += 1;
                        employeesDuplicates.add(allEmployees.get(i));
                        allEmployees.remove(i);
                    }
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
