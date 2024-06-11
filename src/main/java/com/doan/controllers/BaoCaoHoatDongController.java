package com.doan.controllers;

import com.doan.dao.*;
import com.doan.models.BaoCaoHoatDong;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BaoCaoHoatDongController implements Initializable {

    @FXML
    private RadioButton rbNguoiMuon;
    @FXML
    private RadioButton rbNhanVien;
    @FXML
    private RadioButton rbTatCa;
//    @FXML
//    private TableView<BaoCaoHoatDong> tableViewKetQua;
    @FXML
    private TableColumn<BaoCaoHoatDong, String> colMaNhanVien;
    @FXML
    private TableColumn<BaoCaoHoatDong, String> colTenNhanVien;
    @FXML
    private TableColumn<BaoCaoHoatDong, String> colMaNguoiMuon;
    @FXML
    private TableColumn<BaoCaoHoatDong, String> colTenNguoiMuon;
    @FXML
    private TableColumn<BaoCaoHoatDong, String> colMaTaiLieu;
    @FXML
    private TableColumn<BaoCaoHoatDong, String> colTenTaiLieu;
    @FXML
    private TableColumn<BaoCaoHoatDong, String> colMaBanSao;
    @FXML
    private TableColumn<BaoCaoHoatDong, String> colHoatDong;
    @FXML
    private TableColumn<BaoCaoHoatDong, String> colMaPhieuPhat;
    @FXML
    private TableColumn<BaoCaoHoatDong, String> colSoTienPhat;
    @FXML
    private TableColumn<BaoCaoHoatDong, String> colLyDoPhat;
    @FXML
    private TextField tfMa;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TableView<BaoCaoHoatDong> tableViewKetQua;
    private MainController mainController;
    private ObservableList<BaoCaoHoatDong> baoCaoList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Khởi tạo ToggleGroup
        ToggleGroup toggleGroup = new ToggleGroup();
        rbNguoiMuon.setToggleGroup(toggleGroup);
        rbNhanVien.setToggleGroup(toggleGroup);
        rbTatCa.setToggleGroup(toggleGroup);
        rbTatCa.setSelected(true);
        // Khởi tạo các cột
        colMaNhanVien.setCellValueFactory(new PropertyValueFactory<>("maNhanVien"));
        colTenNhanVien.setCellValueFactory(new PropertyValueFactory<>("tenNhanVien"));
        colMaNguoiMuon.setCellValueFactory(new PropertyValueFactory<>("maNguoiMuon"));
        colTenNguoiMuon.setCellValueFactory(new PropertyValueFactory<>("tenNguoiMuon"));
        colMaTaiLieu.setCellValueFactory(new PropertyValueFactory<>("maTaiLieu"));
        colTenTaiLieu.setCellValueFactory(new PropertyValueFactory<>("tenTaiLieu"));
        colMaBanSao.setCellValueFactory(new PropertyValueFactory<>("maBanSao"));
        colHoatDong.setCellValueFactory(new PropertyValueFactory<>("hoatDong"));
        colMaPhieuPhat.setCellValueFactory(new PropertyValueFactory<>("maPhieuPhat"));
        colSoTienPhat.setCellValueFactory(new PropertyValueFactory<>("soTienPhat"));
        colLyDoPhat.setCellValueFactory(new PropertyValueFactory<>("lyDoPhat"));
        tableViewKetQua.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);


    }

    @FXML
    private void handleBaoCao(){
        LocalDate ngay = datePicker.getValue();
        String ma = tfMa.getText();

        if (rbTatCa.isSelected()) {
            if (ngay == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Lỗi");
                alert.setHeaderText(null);
                alert.setContentText("Vui lòng chọn ngày");
                alert.showAndWait();
                return;
            }
        } else if ((ngay == null || ma.isEmpty())) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng chọn ngày và nhập mã đối với nhân viên và người mượn.");
            alert.showAndWait();
            return;
        }
        baoCaoList.clear();
        try {
            ObservableList<BaoCaoHoatDong> data;
            if (rbNguoiMuon.isSelected()) {
                data = NguoiMuonDAO.baoCaoHoatDongNguoiMuonTrongNgay(ma, ngay);
            } else if (rbNhanVien.isSelected()) {
                data = NhanVienDAO.baoCaoHoatDongNhanVienTrongNgay(ma, ngay);
            } else if (rbTatCa.isSelected()) {
                data = HoatDongDAO.BaoCaoHoatDongTrongNgay(ngay);
            } else {
                throw new IllegalArgumentException("Vui lòng chọn loại báo cáo.");
            }
            baoCaoList.addAll(data);
            tableViewKetQua.setItems(baoCaoList);
            tableViewKetQua.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    public TableView<BaoCaoHoatDong> getTableViewKetQua() {
        return tableViewKetQua;
    }

}
