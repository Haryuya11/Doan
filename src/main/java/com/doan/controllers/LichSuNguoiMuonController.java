package com.doan.controllers;

import com.doan.dao.NguoiMuonDAO;
import com.doan.models.PhieuMuon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class LichSuNguoiMuonController implements Initializable {
    @FXML
    TextField tfMaSo;
    @FXML
    ComboBox<String> tinhTrangComboBox;
    @FXML
    Button btnTimKiem;
    @FXML
    TableView<PhieuMuon> tableViewKetQua;
    @FXML
    TableColumn<PhieuMuon, String> colMaTaiLieu;
    @FXML
    TableColumn<PhieuMuon, String> colTenTaiLieu;
    @FXML
    TableColumn<PhieuMuon, String> colMaBanSao;
    @FXML
    TableColumn<PhieuMuon, String> colTinhTrang;
    @FXML
    TableColumn<PhieuMuon, String> colNgayMuon;
    @FXML
    TableColumn<PhieuMuon, String> colHanTra;
    @FXML
    TableColumn<PhieuMuon, String> colNgayTra;
    private final ObservableList<PhieuMuon> phieuMuonList = FXCollections.observableArrayList();
    private MainController mainController;
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Khởi tạo các cột của table view
        colMaTaiLieu.setCellValueFactory(new PropertyValueFactory<>("maTaiLieu"));
        colTenTaiLieu.setCellValueFactory(new PropertyValueFactory<>("tenTaiLieu"));
        colMaBanSao.setCellValueFactory(new PropertyValueFactory<>("maBanSao"));
        colTinhTrang.setCellValueFactory(new PropertyValueFactory<>("tinhTrang"));
        colNgayMuon.setCellValueFactory(new PropertyValueFactory<>("ngayMuon"));
        colHanTra.setCellValueFactory(new PropertyValueFactory<>("hanTra"));
        colNgayTra.setCellValueFactory(new PropertyValueFactory<>("ngayTra"));
        tinhTrangComboBox.getItems().addAll("Tất cả", "Đang mượn", "Đã trả", "Đã làm mất");
        tinhTrangComboBox.setValue("Tất cả");
        tableViewKetQua.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    @FXML
    private void timKiem() {
        String maSo = tfMaSo.getText();
        String tinhTrang = tinhTrangComboBox.getValue();
        // Gọi hàm lichSuMuonSachCuaNguoiMuon từ NguoiMuonDAO
        // Hiển thị kết quả lên table view
        if(tinhTrang.equals("Tất cả")){
            tinhTrang = null;
        }
        if(maSo.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập mã số.");
            alert.showAndWait();
            return;
        }
        phieuMuonList.clear();
        phieuMuonList.addAll(NguoiMuonDAO.lichSuMuonSachCuaNguoiMuon(maSo, tinhTrang));
        tableViewKetQua.setItems(phieuMuonList);
        tableViewKetQua.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    public TableView<PhieuMuon> getTableViewKetQua() {
        return tableViewKetQua;
    }
}
