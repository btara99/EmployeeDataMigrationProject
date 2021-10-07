package com.sparta.employee.controller;

import com.sparta.employee.model.CleaningManager;

public class EmployeeDisplay {

    public void displayDataProcessing(int dupeVal,int cleanVal){
        System.out.println("The amount of duplicate values found in the file: "+ dupeVal);
        System.out.println("The amount of Unique values found in the file: " + cleanVal);

    }
}
