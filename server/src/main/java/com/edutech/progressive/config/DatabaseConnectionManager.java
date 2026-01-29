package com.edutech.progressive.config;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static final Properties properties = new Properties();
    private static void loadProperties(){
        try(FileInputStream input = new FileInputStream("src/main/resources/application.properties")) {
            properties.load(input);
        } catch (Exception e) {
            System.err.println("Error loading properties file: "+e.getMessage());
        }
    }
    public static Connection getConnection() throws SQLException{
        loadProperties();
        String url = properties.getProperty("db.url");
        String username = properties.getProperty("db.username");
        String password = properties.getProperty("db.password");

        return DriverManager.getConnection(url,username,password);
    }
}
