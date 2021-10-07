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
    String line = null;
    int dupeCount = 0;

    public void fileCleaner(){
        try (BufferedReader in = new BufferedReader(new FileReader("EmployeeRecords.csv"))) {
            in.readLine(); // skips the first line
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
            System.out.println(employeesUnique.size());
            System.out.println(employeesDuplicates.size());


        } catch (FileNotFoundException fe){
            fe.printStackTrace();
            System.out.println("File is not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Input output exception");

        }
    }

//    public void fileCleaner() {
//
//        try (BufferedReader in = new BufferedReader(new FileReader("EmployeeRecords.csv"))) {
//            while ((line = in.readLine()) != null) {
//                allEmployees.add(line);
//            }
//            //Used for removing any duplicate values by iterating through the array list and comparing
//            for (int i = 1; i < allEmployees.size(); i++) {
//                for (int j = i + 1; j < allEmployees.size(); j++) {
//                    if (allEmployees.get(i).substring(0, 6).equals(allEmployees.get(j).substring(0, 6))) {
//                        dupeCount += 1;
//                        employeesDuplicates.add(allEmployees.get(i));
//                        allEmployees.remove(i);
//                    }
//                }
//            }
//
//        } catch (FileNotFoundException fe){
//            fe.printStackTrace();
//            System.out.println("File is not found");
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("Input output exception");
//
//        }
//    }

}
