package com.doan.dao;

import com.doan.models.NhanVien;
import com.doan.utils.DatabaseConnection;

import java.sql.*;
import java.time.LocalDate;

import com.doan.models.BaoCaoHoatDong;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class NhanVienDAO {
    public static NhanVien getNhanVienByMaNV(String maNV) {
        NhanVien nhanVien = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM NHANVIEN WHERE MANV = ?")) {
            stmt.setString(1, maNV);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nhanVien = new NhanVien();
                    nhanVien.setMaNV(rs.getString("MANV"));
                    nhanVien.setTenNV(rs.getString("TENNV"));
                    nhanVien.setSdt(rs.getString("SDT"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanVien;
    }
    public static ObservableList<BaoCaoHoatDong> baoCaoHoatDongNhanVienTrongNgay(String maNV, LocalDate ngay) throws SQLException {
        ObservableList<BaoCaoHoatDong> ketQua = FXCollections.observableArrayList();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM BaoCaoHoatDongNhanVienTrongNgay(?, ?)")) {
            stmt.setString(1, maNV);
            stmt.setDate(2, Date.valueOf(ngay));
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
            }
        }
        return ketQua;
    }
}
