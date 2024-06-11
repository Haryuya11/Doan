package com.doan.dao;

import com.doan.utils.DatabaseConnection;
import javafx.scene.control.Alert;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class MuonTraDAO {

    public static void muonTaiLieu(String maSo, String listMaBanSao, LocalDate ngayMuon) {
        try (Connection connection = DatabaseConnection.getConnection();
             CallableStatement stmt = connection.prepareCall("{call MUONTAILIEU(?, ?, ?)}")) {

            stmt.setString(1, maSo);
            stmt.setString(2, listMaBanSao);
            stmt.setDate(3, java.sql.Date.valueOf(ngayMuon));
            stmt.execute();

            // Hiển thị thông báo popup
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Mượn tài liệu thành công.");
            alert.showAndWait();

        } catch (SQLException e) {
            String error = e.getMessage();
            if (error != null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setHeaderText(null);
                alert.setContentText("Error: " + error);
                alert.showAndWait();
            } else {
                e.printStackTrace();
            }
        }
    }

    public static void traTaiLieu(String maSo, String listMaBanSao, LocalDate ngayTra) {
        try (Connection connection = DatabaseConnection.getConnection();
             CallableStatement stmt = connection.prepareCall("{call TRATAILIEU(?, ?, ?)}")) {

            stmt.setString(1, maSo);
            stmt.setString(2, listMaBanSao);
            stmt.setDate(3, java.sql.Date.valueOf(ngayTra));
            stmt.execute();

            // Hiển thị thông báo popup
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Trả tài liệu thành công.");
            alert.showAndWait();
        } catch (SQLException e) {
//            e.printStackTrace();
            String error = e.getMessage();
            if (error != null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setHeaderText(null);
                alert.setContentText("Error: " + error);
                alert.showAndWait();
            } else {
                e.printStackTrace();
            }
            // Xử lý lỗi (ví dụ: hiển thị thông báo lỗi cho người dùng)
        }
    }
}
