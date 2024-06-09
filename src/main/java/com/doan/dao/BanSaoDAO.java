package com.doan.dao;

import com.doan.models.BanSao;
import com.doan.utils.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BanSaoDAO {
    public static ObservableList<BanSao> layThongTinBanSao(String maTaiLieu, String trangThai) {
        ObservableList<BanSao> ketQua = FXCollections.observableArrayList();
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM LayThongTinBanSao(?, ?)")) {
            stmt.setString(1, maTaiLieu);
            stmt.setNString(2, trangThai);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.isBeforeFirst()) {
                    System.out.println("Không tìm thấy bản sao nào.");
                } else while (rs.next()) {
                    BanSao banSao = new BanSao();
                    banSao.setMaTaiLieu(rs.getString("MATL"));
                    banSao.setMaBanSao(rs.getString("MABANS"));
                    banSao.setTrangThai(rs.getString("TRANGTHAI"));
                    banSao.setSoPhong(rs.getString("SOPHONG"));
                    banSao.setSoKe(rs.getString("SOKE"));
                    banSao.setSoNgan(rs.getString("SONGAN"));
                    ketQua.add(banSao);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ketQua;
    }
}
