package com.doan.controllers;

import com.doan.application.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.doan.utils.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    @FXML private TextField tfMaNhanVien;
    @FXML private PasswordField pfMatKhau;
    @FXML private Label lblThongBao;

    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    private void handleDangNhap() {
        String maNhanVien = tfMaNhanVien.getText();
        String matKhau = pfMatKhau.getText();

        if (maNhanVien.isEmpty() || matKhau.isEmpty()) {
            lblThongBao.setText("Vui lòng nhập đầy đủ thông tin!");
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(
                     "SELECT * FROM NHANVIEN WHERE MANV = ?")) {

            stmt.setString(1, maNhanVien);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next() && (maNhanVien + "12345").equals(matKhau)) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/Main.fxml"));
                    Parent root = loader.load();

                    MainController mainController = loader.getController();
                    mainController.setThongTinNhanVien(rs.getString("TENNV"), maNhanVien);

                    Scene scene = new Scene(root);
                    app.getPrimaryStage().setScene(scene);
                } else {
                    lblThongBao.setText("Sai mã nhân viên hoặc mật khẩu!");
                }
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            lblThongBao.setText("Lỗi: " + e.getMessage());
        }
    }
}
