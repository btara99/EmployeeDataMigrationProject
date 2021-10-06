package com.sparta.employee;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLOutput;
import java.util.*;

public class EmployeeDriver {

    public static void main(String[] args) {
        ArrayList<String> allEmployees = new ArrayList<String>();
        ArrayList<String> employeesDuplicates = new ArrayList<String>();
        String line = null;
        int dupeCount = 0;
        try(BufferedReader in  = new BufferedReader(new FileReader("EmployeeRecords.csv"))){
            while((line = in.readLine()) != null){
                //String[] row = line.split(",");
                //employeesID.add(row[0]);
                allEmployees.add(line);
              //employeesID.add(line.substring(0,6));
            }
            for(int i = 1; i < allEmployees.size(); i++){
                for(int j = i+1;j < allEmployees.size();j++){
                    if(allEmployees.get(i).substring(0,6).equals(allEmployees.get(j).substring(0,6))){
                        dupeCount += 1;

                    }
                }
            }

            //GO THROUGH ARRAY OF ALL EMPLOYEESS AND COMPARE SUBTREING OF EMPLOYYE ID
        }
        catch (IOException e) {
            e.printStackTrace();
        }

//        Date d = Date.valueOf("2021-10-05"); // THIS CREATES A DATE OBJECT OF A STRING SO USE THIS TO DO SO
//        System.out.println(d);
        //System.out.println(employeesID.get(1));
        System.out.println(dupeCount);
        //System.out.println(employeesID.get(1));
        System.out.println(allEmployees.get(1));
//        System.out.println(allEmployees.get(1).substring(0,6));
//        //System.out.println(employeesDuplicates);
        //System.out.println(Files.isRegularFile(myPath)); // checks if its a reg file (look at doc for more checks)
    }
}

   // EmployeeInfo employeeInfo = new EmployeeInfo(Integer.valueOf(row[0]),row[1],row[2],row[3],row[4],row[5],row[6],Date.valueOf(row[7]),Date.valueOf(row[8]),Integer.valueOf(row[9]));

