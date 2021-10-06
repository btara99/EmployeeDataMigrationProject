package com.sparta.employee;

public class EmployeeDriver {

    public static void main(String[] args) {
        CleaningManager cleaningManager = new CleaningManager();

        cleaningManager.fileCleaner();

//        //String[] row = line.split(",");
//        //employeesID.add(row[0]);
//        //employeesID.add(line.substring(0,6));
////        Date d = Date.valueOf("2021-10-05"); // THIS CREATES A DATE OBJECT OF A STRING SO USE THIS TO DO SO
////        System.out.println(d);
//        //System.out.println(employeesID.get(1));
//        System.out.println(dupeCount);
//        //System.out.println(employeesID.get(1));
//        System.out.println(allEmployees.size());
        System.out.println(cleaningManager.employeesDuplicates.size());
//        System.out.println(allEmployees.get(1).substring(0,6));
//        //System.out.println(employeesDuplicates);
        //System.out.println(Files.isRegularFile(myPath)); // checks if its a reg file (look at doc for more checks)
    }
}

   // EmployeeInfo employeeInfo = new EmployeeInfo(Integer.valueOf(row[0]),row[1],row[2],row[3],row[4],row[5],row[6],Date.valueOf(row[7]),Date.valueOf(row[8]),Integer.valueOf(row[9]));

