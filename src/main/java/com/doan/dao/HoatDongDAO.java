package com.doan.dao;

import com.doan.models.BaoCaoHoatDong;
import com.doan.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class HoatDongDAO {
    public static ObservableList<BaoCaoHoatDong> BaoCaoHoatDongTrongNgay(LocalDate ngay) throws SQLException {
        ObservableList<BaoCaoHoatDong> ketQua = FXCollections.observableArrayList();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM BaoCaoHoatDongTrongNgay(?)")) {
            stmt.setDate(1, Date.valueOf(ngay));
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    BaoCaoHoatDong baoCao = new BaoCaoHoatDong();
                    baoCao.setMaNhanVien(rs.getString("MaNhanVien"));
                    baoCao.setTenNhanVien(rs.getString("TenNhanVien"));
                    baoCao.setMaNguoiMuon(rs.getString("MaNguoiMuon"));
                    baoCao.setTenNguoiMuon(rs.getString("TenNguoiMuon"));
                    baoCao.setMaTaiLieu(rs.getString("MaTaiLieu"));
                    baoCao.setTenTaiLieu(rs.getString("TenTaiLieu"));
                    baoCao.setMaBanSao(rs.getString("MaBanSao"));
                    baoCao.setHoatDong(rs.getString("HoatDong"));
                    baoCao.setMaPhieuPhat(rs.getString("MaPhieuPhat")); // Kiểm tra null trước khi gán
                    baoCao.setSoTienPhat(rs.getString("SoTienPhat"));   // Kiểm tra null trước khi gán
                    baoCao.setLyDoPhat(rs.getString("LyDoPhat"));     // Kiểm tra null trước khi gán
                    ketQua.add(baoCao);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return ketQua;
    }
}
