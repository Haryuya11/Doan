package com.doan.dao;

import com.doan.utils.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class PhieuTraDAO {

    public static void traTaiLieu(String maSo, String listMaBanSao, LocalDate ngayTra) {
        try (Connection connection = DatabaseConnection.getConnection();
             CallableStatement stmt = connection.prepareCall("{call TRATAILIEU(?, ?, ?)}")) {

            stmt.setString(1, maSo);
            stmt.setString(2, listMaBanSao);
            stmt.setDate(3, java.sql.Date.valueOf(ngayTra));
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi (ví dụ: hiển thị thông báo lỗi cho người dùng)
        }
    }
}
