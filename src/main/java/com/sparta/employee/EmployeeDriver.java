package com.sparta.employee;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeDriver {

    public static void main(String[] args) {
        ArrayList<String> employees = new ArrayList<String>();
        ArrayList<String> employeesDuplicated = new ArrayList<String>();
        Map<String,String> employeeMap = new HashMap<String, String>();
        Path myPath = Paths.get("EmployeeRecords.csv");
        String line = null;
        try(BufferedReader in  = new BufferedReader(new FileReader("EmployeeRecords.csv"))){
            while((line = in.readLine()) != null){
                //String.split(",");
                employees.add(line);

            }
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
//        Date d = Date.valueOf("2021-10-05"); // THIS CREATES A DATE OBJECT OF A STRING SO USE THIS TO DO SO
//        System.out.println(d);
        System.out.println(employees.get(0));
        System.out.println(employees.get(1));
        System.out.println(employees.get(2));
        //System.out.println(Files.isRegularFile(myPath)); // checks if its a reg file (look at doc for more checks)
    }
}
