package com.doan.dao;

import com.doan.models.TaiLieu;
import com.doan.models.TaiLieuQuaHan;
import com.doan.models.ThongKe;
import com.doan.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaiLieuDAO {

    public static ObservableList<ThongKe> thongKeMuonTheoLoai() {
        ObservableList<ThongKe> ketQua = FXCollections.observableArrayList();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ThongKeMuonTheoLoaiTaiLieu()")) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    System.out.println("Không tìm thấy nào.");
                } else while (rs.next()) {
                    ThongKe thongKe = new ThongKe();
                    thongKe.setTenLoaiTL(rs.getString("TENLOAITL"));
                    thongKe.setSoLuong(rs.getInt("SoLuong")); // Đảm bảo tên cột khớp với tên thuộc tính
                    ketQua.add(thongKe);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý lỗi (hiển thị thông báo lỗi, ...)
        }
        return ketQua;
    }

    public static ObservableList<ThongKe> thongKeTaiLieuTheoTheLoai() {
        ObservableList<ThongKe> ketQua = FXCollections.observableArrayList();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM ThongKeTaiLieuTheoTheLoai()")) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    System.out.println("Không tìm thấy.");
                } else while (rs.next()) {
                    ThongKe thongke = new ThongKe();
                    thongke.setTenLoaiTL(rs.getString("TENLOAITL"));
                    thongke.setSoLuong(rs.getInt("SoLuong"));
                    ketQua.add(thongke);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public static ObservableList<TaiLieuQuaHan> taiLieuQuaHan() {
        ObservableList<TaiLieuQuaHan> ketQua = FXCollections.observableArrayList();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TaiLieuQuaHan()")) {
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    System.out.println("Không tìm thấy.");
                } else while (rs.next()) {
                    TaiLieuQuaHan taiLieuQuaHan = new TaiLieuQuaHan();
                    taiLieuQuaHan.setMaSo(rs.getString("MASO"));
                    taiLieuQuaHan.setHoTen(rs.getString("HOTEN"));
                    taiLieuQuaHan.setMaTaiLieu(rs.getString("MATL"));
                    taiLieuQuaHan.setMaBanSao(rs.getString("MABANS"));
                    taiLieuQuaHan.setHanTra(rs.getDate("HANTRA").toLocalDate().toString());
                    taiLieuQuaHan.setSoNgayQuaHan(rs.getInt("SoNgayQuaHan"));
                    ketQua.add(taiLieuQuaHan);
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return ketQua;
    }

    public static ObservableList<TaiLieu> timKiemTaiLieu(String tuKhoa) {
        ObservableList<TaiLieu> ketQua = FXCollections.observableArrayList();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM TimKiemTaiLieu(?)")) {
            stmt.setNString(1, tuKhoa); // Sử dụng NString cho NVARCHAR
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    TaiLieu taiLieu = new TaiLieu();
                    taiLieu.setMaTaiLieu(rs.getString("MATL"));
                    taiLieu.setTenTaiLieu(rs.getString("TENTL"));
                    taiLieu.setTacGia(rs.getString("TACGIA"));
                    taiLieu.setNgonNgu(rs.getString("NGONNGU"));
                    taiLieu.setSoTrang(rs.getInt("SOTRANG"));
                    taiLieu.setMaLoaiTL(rs.getString("MALOAITL"));
                    taiLieu.setTenLoaiTL(rs.getString("TENLOAITL"));
                    taiLieu.setGia(rs.getString("GIA"));
                    taiLieu.setSoLuong(rs.getInt("SOLUONG"));
                    // Không cần lấy thông tin vị trí từ bảng VITRI nữa
                    ketQua.add(taiLieu);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }

}
