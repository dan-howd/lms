package com.ss.lms2;

import java.sql.*;

// Supposed to register the MySQL connector
public class MySQL {
    private static Connection connection;
    private static void testConnection() {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void initializeConnection() {
        try {
            connection =
                DriverManager.getConnection("jdbc:mysql://localhost/library?" +
                "user=root&password=root");
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public static Connection getConnection() {
        testConnection();
        if (connection == null) {
            initializeConnection();
        }
        return connection;
    }

    public static ResultSet doQuery(String query) {
        Connection dbConn = getConnection();
        ResultSet resultSet = null;
        Statement stmt = null;
        try {
            stmt = dbConn.createStatement();
            if (stmt.execute(query)) {
                resultSet = stmt.getResultSet();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}


