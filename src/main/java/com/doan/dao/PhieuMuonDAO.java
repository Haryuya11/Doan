package com.doan.dao;

import com.doan.utils.DatabaseConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class PhieuMuonDAO {

    public static void muonTaiLieu(String maSo, String listMaBanSao, LocalDate ngayMuon) {
        try (Connection connection = DatabaseConnection.getConnection();
             CallableStatement stmt = connection.prepareCall("{call MUONTAILIEU(?, ?, ?)}")) {

            stmt.setString(1, maSo);
            stmt.setString(2, listMaBanSao);
            stmt.setDate(3, java.sql.Date.valueOf(ngayMuon));
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi ở đây, ví dụ: hiển thị thông báo lỗi cho người dùng
        }
    }

    public static void traTaiLieu(String maSo, String listMaBanSao, LocalDate ngayTra) {
        try (Connection connection = DatabaseConnection.getConnection();
             CallableStatement stmt = connection.prepareCall("{call TRATAILIEU(?, ?, ?)}")) {

            stmt.setString(1, maSo);
            stmt.setString(2, listMaBanSao);
            stmt.setDate(3, java.sql.Date.valueOf(ngayTra));
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi ở đây
        }
    }
}
