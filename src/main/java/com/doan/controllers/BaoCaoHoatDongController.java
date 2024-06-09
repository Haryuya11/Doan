package com.doan.controllers;

import com.doan.dao.NhanVienDAO;
import com.doan.dao.NguoiMuonDAO;
import com.doan.models.BaoCaoHoatDong;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BaoCaoHoatDongController implements Initializable {

    @FXML private DatePicker datePicker;
    @FXML private TextField tfMa;
    @FXML private RadioButton rbNguoiMuon;
    @FXML private RadioButton rbNhanVien;
    @FXML private Button btnBaoCaoHoatDong;
    @FXML private TableView<BaoCaoHoatDong> tableViewBaoCaoHoatDong;
    @FXML private TableColumn<BaoCaoHoatDong, String> colMaNhanVien;
    @FXML private TableColumn<BaoCaoHoatDong, String> colTenNhanVien;
    @FXML private TableColumn<BaoCaoHoatDong, String> colMaNguoiMuon;
    @FXML private TableColumn<BaoCaoHoatDong, String> colTenNguoiMuon;
    @FXML private TableColumn<BaoCaoHoatDong, String> colMaTaiLieu;
    @FXML private TableColumn<BaoCaoHoatDong, String> colTenTaiLieu;
    @FXML private TableColumn<BaoCaoHoatDong, String> colMaBanSao;
    @FXML private TableColumn<BaoCaoHoatDong, String> colHoatDong;
    @FXML private TableColumn<BaoCaoHoatDong, String> colMaPhieuPhat;
    @FXML private TableColumn<BaoCaoHoatDong, String> colSoTienPhat;
    @FXML private TableColumn<BaoCaoHoatDong, String> colLyDoPhat;
    @FXML private VBox layout;

    private MainController mainController;
    private ObservableList<BaoCaoHoatDong> baoCaoList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Khởi tạo ToggleGroup
        ToggleGroup toggleGroup = new ToggleGroup();
        rbNguoiMuon.setToggleGroup(toggleGroup);
        rbNhanVien.setToggleGroup(toggleGroup);

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

        tableViewBaoCaoHoatDong.setItems(baoCaoList);
    }

    @FXML
    private void handleBaoCaoHoatDong() {
        LocalDate ngay = datePicker.getValue();
        String ma = tfMa.getText();

        if (ngay == null || ma.isEmpty()) {
            // Xử lý trường hợp người dùng chưa nhập đủ thông tin
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng chọn ngày và nhập mã.");
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
            } else {
                throw new IllegalArgumentException("Vui lòng chọn loại báo cáo (Người mượn hoặc Nhân viên).");
            }
            baoCaoList.addAll(data); // Thêm dữ liệu vào ObservableList
        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
            // Xử lý lỗi (hiển thị thông báo lỗi, ...)
        }
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public VBox getLayout() {
        return layout;
    }
}
