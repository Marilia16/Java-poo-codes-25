package com.login.repository.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
    private static final String USER = "postgres";
    private static final String PASSWORD = "mari4010L";
    private static final String URL = "jdbc:postgresql://localhost:4010/dblogins?useUnicode=true&characterEncoding=UTF-8";


    public static Connection getConnection() {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(DBConnection.URL, DBConnection.USER, DBConnection.PASSWORD);
        
        }catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        return conn;
    }
}
