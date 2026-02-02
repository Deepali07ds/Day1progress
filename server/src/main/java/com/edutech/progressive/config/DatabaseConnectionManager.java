package com.edutech.progressive.config;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static final Properties properties = new Properties();

    private static void loadProperties() {
        try (FileInputStream input = new FileInputStream(
                "/home/coder/app/server/src/main/resources/application.properties")) {
            properties.load(input);
        } catch (Exception e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        Connection connection=null;
        try {
            loadProperties();
            String url = properties.getProperty("spring.datasource.url");
            String username = properties.getProperty("spring.datasource.username");
            String password = properties.getProperty("spring.datasource.password");

            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
