package com.sparta.employee.controller;

public class DisplayManger {

    private static final String displayThreads = // display the title so user can pick what to sort
                    "\t*************************************\n" +
                    "\t|  Pick a number between 1-2 for    |\n" +
                    "\t|  the type of thread               |\n" +
                    "\t|                                   |\n" +
                    "\t| Type: 1 for Single Thread         |\n" +
                    "\t| Type: 2 for Multi Thread          |\n" +
                    "\t************************************\n" ;

    private static final String displaySQLStatements = // display the title so user can pick what to sort
                     "\t*****************************************\n" +
                    "\t|  Pick a number between 1-7 for some    |\n" +
                    "\t|  SQL Querying                          |\n" +
                    "\t|                                        |\n" +
                    "\t| Type: 1 get 100 employees              |\n" +
                    "\t| Type: 2 Top 10 highest salary          |\n" +
                    "\t| Type: 3 Top 10 Oldest employees        |\n" +
                    "\t| Type: 4 Top 10 recently hired          |\n" +
                    "\t| Type: 5 get the Female employees       |\n" +
                    "\t| Type: 6 get the salary above 5 figures |\n" +
                    "\t| Type: 7 to EXIT                        |\n" +
                     "\t*****************************************\n" ;


    public static String getDisplayThreads(){
        return displayThreads;
    }

    public static String getDisplaySQLStatements(){
        return displaySQLStatements;
    }
}
