package com.sparta.employee.testing;

import com.sparta.employee.model.EmployeeProcessing;
import org.junit.jupiter.api.Test;


import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CleaningManagerTest {

    @Test
    public void dateFormatTest() throws ParseException {
        EmployeeProcessing employeeProcessing = new EmployeeProcessing();
        String date = "9/21/1982";
        assertTrue(employeeProcessing.dateFormater(date).toString().equals("1982-09-21"));
    }
}
