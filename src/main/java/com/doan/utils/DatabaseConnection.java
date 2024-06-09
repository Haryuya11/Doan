package com.doan.utils;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        Connection c = null;
        try {
            // Khởi tạo url để kết nối
            String url = "jdbc:sqlserver://HARUYA:1433;databaseName=QUANLYTHUVIEN;encrypt=true;trustServerCertificate=true;user=sa;password=12345";
            // Tạo kết nối
            c = DriverManager.getConnection(url);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return c;
    }

    public static void closeConnection(Connection c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
