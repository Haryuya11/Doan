package com.doan.controllers;

import com.doan.dao.PhieuMuonDAO;
import com.doan.dao.PhieuTraDAO;
import javafx.fxml.FXML;
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
    @FXML
    private Button btnMuon;
    @FXML
    private Button btnTra;


    private MainController mainController; // Thêm thuộc tính mainController

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    @FXML
    private void handleMuonTaiLieu() {
        String maNguoiMuon = tfMaNguoiMuon.getText();
        String maBanSao = tfMaBanSao.getText();
        LocalDate ngayMuonTra = datePickerNgayMuonTra.getValue();

        // Gọi procedure MUONTAILIEU từ PhieuMuonDAO
        PhieuMuonDAO.muonTaiLieu(maNguoiMuon, maBanSao, ngayMuonTra);
    }

    @FXML
    private void handleTraTaiLieu() {
        String maNguoiMuon = tfMaNguoiMuon.getText();
        String maBanSao = tfMaBanSao.getText();
        LocalDate ngayMuonTra = datePickerNgayMuonTra.getValue();

        // Gọi procedure TRATAILIEU từ PhieuTraDAO
        PhieuTraDAO.traTaiLieu(maNguoiMuon, maBanSao, ngayMuonTra);
    }
}
