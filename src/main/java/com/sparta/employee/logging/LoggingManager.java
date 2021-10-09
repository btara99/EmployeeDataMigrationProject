package com.sparta.employee.logging;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

//Used for logging key points

public class LoggingManager {
    private static Logger logger = Logger.getLogger("Java sorter app logger");

    public static void sqlExceptionLog(SQLException n){
        PropertyConfigurator.configure("log4j.properties");  // log for exceptions
        logger.warn("SQL exception " + n);
    }
    public static void ioLog(IOException arr){
        PropertyConfigurator.configure("log4j.properties"); // log when arrays are made
        logger.warn("IO log " + arr);
    }
    public static void timeLog(double time){
        PropertyConfigurator.configure("log4j.properties");  // logs the time of the sort
        logger.warn("time taken for single thread completion " + time + " seconds");
    }

    public static void timeLogMultiThread(double time){
        PropertyConfigurator.configure("log4j.properties");  // logs the time of the sort
        logger.warn("time taken for multi thread completion " + time + " seconds");
    }

    public static void timeLogForCleaning(double time){
        PropertyConfigurator.configure("log4j.properties");  // logs the time of the sort
        logger.warn("time taken for single thread completion " + time + " seconds");
    }

    public static void fileNotFound(FileNotFoundException fe){
        PropertyConfigurator.configure("log4j.properties");  // logs the time of the sort
        logger.warn("File was not found " + fe) ;
    }

    public static void normalException(Exception fe){
        PropertyConfigurator.configure("log4j.properties");  // logs the time of the sort
        logger.warn("exception at " + fe) ;
    }

}
