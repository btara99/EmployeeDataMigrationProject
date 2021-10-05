package com.sparta.employee;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;

public class EmployeeDriver {
    public static void main(String[] args) {
        String line = null;
        try(BufferedReader in  = new BufferedReader(new FileReader("canada.csv"));
            BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"))){
            while((line = in.readLine()) != null){
                System.out.println(line);
                out.write(line + "\n");
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Date d = Date.valueOf("2021-10-05"); // THIS CREATES A DATE OBJECT OF A STRING SO USE THIS TO DO SO
        System.out.println(d);

        Path myPath = Paths.get("canada.csv");
        System.out.println(myPath);
        System.out.println(Files.isRegularFile(myPath)); // checks if its a reg file (look at doc for more checks)
    }
}
