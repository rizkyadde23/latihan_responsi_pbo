package com.pbo.latres.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADVAN
 */
public class DatabaseConnection {

    private static volatile DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/prak_pbo_todo";
            String user = "root";
            String password = "";
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi Database Berhasil");
        } catch (SQLException e) {
            throw new RuntimeException("Koneksi gagal: " + e.getMessage());
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
