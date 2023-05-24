package com.example.exam2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
public class ExceptionLogger {
    private static ExceptionLogger instance = null;
    private PrintWriter writer;

    private ExceptionLogger() {
        // Private constructor to prevent direct instantiation
        try {
            writer = new PrintWriter(new FileWriter("exception_log.txt", true));
        } catch (IOException e) {
            System.err.println("Failed to create exception log file: " + e.getMessage());
        }
    }
    public static synchronized ExceptionLogger getInstance() {
        if (instance == null) {
            instance = new ExceptionLogger();
        }
        return instance;
    }

    public void logException(Exception e) {
        if (writer != null) {
            writer.println("Exception: " + e.getClass().getName());
            writer.println("Message: " + e.getMessage());
            writer.println("Date: " + LocalDateTime.now());
            writer.println("Stack Trace:");
            e.printStackTrace(writer);
            writer.println("--------------------");
            writer.flush();
        } else {
            System.err.println("Failed to log exception: log file is not available.");
        }
    }

    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
