package com.doan.controllers;

import com.doan.dao.NguoiMuonDAO;
import com.doan.models.NguoiMuon;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TraCuuPhieuPhatController {
    @FXML
    private TextField tfMaSo;
    @FXML
    private Button btnTraCuu;
    @FXML
    private Label lblTongTienPhat;
    @FXML
    private TextArea taDanhSachPhat;

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void handleTraCuu() {
        String maSo = tfMaSo.getText().trim();
        if (maSo.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập mã.");
            alert.showAndWait();
            return;
        }

        NguoiMuon nguoiMuon = NguoiMuonDAO.thongTinPhatNguoiMuon(maSo);
        if (nguoiMuon != null) {
            lblTongTienPhat.setText(String.format("Tổng tiền phạt: %.0f VND", nguoiMuon.getTongTienPhat()));
            taDanhSachPhat.setText(nguoiMuon.getDanhSachPhat());
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Thông báo");
            alert.setHeaderText(null);
            alert.setContentText("Không tìm thấy thông tin phạt của người mượn này.");
            alert.showAndWait();
        }
    }
}
