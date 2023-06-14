package com.example.exam2;

import java.sql.*;

public class db {
    private static ExceptionLogger log = ExceptionLogger.getInstance();
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/organize_exam";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static Connection connection;

    public static Connection getDBConnection() throws SQLException {
        if(connection == null) {
            try {
                Class.forName(DB_DRIVER);
            } catch (ClassNotFoundException exception) {
                log.logException(exception);
            }
            try {
                connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
                return connection;
            } catch (SQLException exception) {
                log.logException(exception);
            }
        }
        return connection;
    }
}



