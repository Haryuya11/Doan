package com.doan.controllers;

import com.doan.dao.MuonTraDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class MuonTraTaiLieuController {
    @FXML
    private TextField tfMaNguoiMuon;
    @FXML
    private TextField tfMaBanSao;
    @FXML
    private DatePicker datePickerNgayMuonTra;


    private MainController mainController; // Thêm thuộc tính mainController

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void handleMuonTaiLieu() {
        String maNguoiMuon = tfMaNguoiMuon.getText();
        String maBanSao = tfMaBanSao.getText();
        LocalDate ngayMuonTra = datePickerNgayMuonTra.getValue();
        if (ngayMuonTra == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng chọn ngày .");
            alert.showAndWait();
            return;
        }
        MuonTraDAO.muonTaiLieu(maNguoiMuon, maBanSao, ngayMuonTra);
    }

    @FXML
    private void handleTraTaiLieu() {
        String maNguoiMuon = tfMaNguoiMuon.getText();
        String maBanSao = tfMaBanSao.getText();
        LocalDate ngayMuonTra = datePickerNgayMuonTra.getValue();
        if (ngayMuonTra == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng chọn ngày .");
            alert.showAndWait();
            return;
        }
        MuonTraDAO.traTaiLieu(maNguoiMuon, maBanSao, ngayMuonTra);
    }
}
