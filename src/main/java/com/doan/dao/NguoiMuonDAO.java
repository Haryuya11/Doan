package com.doan.dao;

import com.doan.models.BaoCaoHoatDong;
import com.doan.models.NguoiMuon;
import com.doan.models.PhieuMuon;
import com.doan.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class NguoiMuonDAO {

    public static ObservableList<PhieuMuon> lichSuMuonSachCuaNguoiMuon(String maSo, String tinhTrang) {
        ObservableList<PhieuMuon> ketQua = FXCollections.observableArrayList();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM LichSuMuonSachCuaNguoiMuon(?, ?)")) {
            stmt.setString(1, maSo);
            stmt.setString(2, tinhTrang);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    PhieuMuon phieuMuon = new PhieuMuon();
                    phieuMuon.setMaTaiLieu(rs.getString("MATL"));
                    phieuMuon.setTenTaiLieu(rs.getString("TENTL"));
                    phieuMuon.setMaBanSao(rs.getString("MABANS"));
                    phieuMuon.setTinhTrang(rs.getString("TINHTRANG"));
                    phieuMuon.setNgayMuon(rs.getDate("NGAYMUON").toLocalDate());
                    if (rs.getDate("HANTRA") != null) {
                        phieuMuon.setHanTra(rs.getDate("HANTRA").toLocalDate());
                    }
                    if (rs.getDate("NGAYTRA") != null) {
                        phieuMuon.setNgayTra(rs.getDate("NGAYTRA").toLocalDate());
                    }
                    ketQua.add(phieuMuon);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public static NguoiMuon thongTinPhatSinhVien(String maSo) {
        NguoiMuon nguoiMuon = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ThongTinPhatSinhVien(?)")) {
            stmt.setString(1, maSo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nguoiMuon = new NguoiMuon();
                    nguoiMuon.setMaSo(rs.getString("MASO"));
                    nguoiMuon.setTongTienPhat(rs.getDouble("TongTienPhat"));
                    nguoiMuon.setDanhSachPhat(rs.getString("DanhSachPhat"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nguoiMuon;
    }
    public static ObservableList<BaoCaoHoatDong> baoCaoHoatDongNguoiMuonTrongNgay(String maSo, LocalDate ngay) throws SQLException {
        ObservableList<BaoCaoHoatDong> ketQua = FXCollections.observableArrayList();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM BaoCaoHoatDongNguoiMuonTrongNgay(?, ?)")) {
            stmt.setString(1, maSo);
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
