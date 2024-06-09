package com.doan.controllers;

import com.doan.dao.NhanVienDAO;
import com.doan.dao.NguoiMuonDAO;
import com.doan.dao.TaiLieuDAO;
import com.doan.models.BaoCaoHoatDong;
import com.doan.models.TaiLieu;
import com.doan.models.TaiLieuQuaHan;
import com.doan.models.ThongKeMuonTheoLoai;
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

public class ThongKeBaoCaoController implements Initializable {

    // ... (Các khai báo @FXML cho các nút, TableView, DatePicker, TextField, RadioButtons)
    @FXML
    private Button btnThongKeMuonTheoLoai;
    @FXML
    private Button btnThongKeTaiLieuTheoTheLoai;
    @FXML
    private Button btnTaiLieuQuaHan;
    @FXML
    private Button btnBaoCaoHoatDong;

    @FXML
    private TableView tableViewKetQua;

    @FXML
    private DatePicker datePicker; // Cho báo cáo hoạt động

    @FXML
    private TextField tfMa; // Cho báo cáo hoạt động

    @FXML
    private RadioButton rbNguoiMuon; // Cho báo cáo hoạt động

    @FXML
    private RadioButton rbNhanVien; // Cho báo cáo hoạt động
    private ObservableList<ThongKeMuonTheoLoai> thongKeMuonTheoLoaiList = FXCollections.observableArrayList();
    private ObservableList<TaiLieu> taiLieuList = FXCollections.observableArrayList();
    private ObservableList<TaiLieuQuaHan> taiLieuQuaHanList = FXCollections.observableArrayList();
    private ObservableList<BaoCaoHoatDong> baoCaoList = FXCollections.observableArrayList();

    private MainController mainController; // Thêm thuộc tính mainController

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableViewKetQua.setItems(thongKeMuonTheoLoaiList);
        ToggleGroup toggleGroup = new ToggleGroup();
        rbNguoiMuon.setToggleGroup(toggleGroup);
        rbNhanVien.setToggleGroup(toggleGroup);
        rbNguoiMuon.setSelected(true); // Mặc định chọn báo cáo người mượn
    }

    @FXML
    private void handleThongKeMuonTheoLoai() {
        tableViewKetQua.getColumns().clear();
        tableViewKetQua.getItems().clear();

        // Khởi tạo các cột cho báo cáo thống kê mượn theo loại
        TableColumn<ThongKeMuonTheoLoai, String> colMaLoai = new TableColumn<>("Mã Loại");
        colMaLoai.setCellValueFactory(new PropertyValueFactory<>("maLoaiTL"));
        TableColumn<ThongKeMuonTheoLoai, String> colTenLoai = new TableColumn<>("Tên Loại");
        colTenLoai.setCellValueFactory(new PropertyValueFactory<>("tenLoaiTL"));
        TableColumn<ThongKeMuonTheoLoai, Integer> colSoLuongMuon = new TableColumn<>("Số Lượng Mượn");
        colSoLuongMuon.setCellValueFactory(new PropertyValueFactory<>("soLuongMuon"));

        tableViewKetQua.getColumns().addAll(colMaLoai, colTenLoai, colSoLuongMuon);

        thongKeMuonTheoLoaiList.clear();
        thongKeMuonTheoLoaiList.addAll(TaiLieuDAO.thongKeMuonTheoLoaiTaiLieu());
        tableViewKetQua.setItems(thongKeMuonTheoLoaiList);
    }

    @FXML
    private void handleThongKeTaiLieuTheoTheLoai() {
        tableViewKetQua.getColumns().clear();
        tableViewKetQua.setItems(null);

        TableColumn<TaiLieu, String> colTenLoai = new TableColumn<>("Thể Loại");
        colTenLoai.setCellValueFactory(new PropertyValueFactory<>("tenLoaiTL"));
        TableColumn<TaiLieu, Integer> colSoLuong = new TableColumn<>("Số Lượng");
        colSoLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));

        tableViewKetQua.getColumns().addAll(colTenLoai, colSoLuong);

        taiLieuList.clear();
        taiLieuList.addAll(TaiLieuDAO.thongKeTaiLieuTheoTheLoai());
        tableViewKetQua.setItems(taiLieuList);
    }

    @FXML
    private void handleTaiLieuQuaHan() {
        tableViewKetQua.getColumns().clear();
        tableViewKetQua.setItems(null);

        // Khởi tạo các cột cho báo cáo tài liệu quá hạn
        TableColumn<TaiLieuQuaHan, String> colMaSo = new TableColumn<>("Mã Số");
        colMaSo.setCellValueFactory(new PropertyValueFactory<>("maSo"));
        TableColumn<TaiLieuQuaHan, String> colHoTen = new TableColumn<>("Họ Tên");
        colHoTen.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        TableColumn<TaiLieuQuaHan, String> colMaTaiLieu = new TableColumn<>("Mã Tài Liệu");
        colMaTaiLieu.setCellValueFactory(new PropertyValueFactory<>("maTaiLieu"));
        TableColumn<TaiLieuQuaHan, String> colTenTaiLieu = new TableColumn<>("Tên Tài Liệu");
        colTenTaiLieu.setCellValueFactory(new PropertyValueFactory<>("tenTaiLieu"));
        TableColumn<TaiLieuQuaHan, String> colHanTra = new TableColumn<>("Hạn Trả");
        colHanTra.setCellValueFactory(new PropertyValueFactory<>("hanTra"));
        TableColumn<TaiLieuQuaHan, Integer> colSoNgayQuaHan = new TableColumn<>("Số Ngày Quá Hạn");
        colSoNgayQuaHan.setCellValueFactory(new PropertyValueFactory<>("soNgayQuaHan"));

        tableViewKetQua.getColumns().addAll(colMaSo, colHoTen, colMaTaiLieu, colTenTaiLieu, colHanTra, colSoNgayQuaHan);

        taiLieuQuaHanList.clear();
        taiLieuQuaHanList.addAll(TaiLieuDAO.taiLieuQuaHan());
        tableViewKetQua.setItems(taiLieuQuaHanList);
    }

    @FXML
    private void handleBaoCaoHoatDong() {
        tableViewKetQua.getColumns().clear();
        tableViewKetQua.setItems(null);

        // Khởi tạo các cột cho báo cáo hoạt động
        TableColumn<BaoCaoHoatDong, String> colMaNhanVien = new TableColumn<>("Mã Nhân Viên");
        colMaNhanVien.setCellValueFactory(new PropertyValueFactory<>("maNhanVien"));
        TableColumn<BaoCaoHoatDong, String> colTenNhanVien = new TableColumn<>("Tên Nhân Viên");
        colTenNhanVien.setCellValueFactory(new PropertyValueFactory<>("tenNhanVien"));
        // ... (Thêm các cột khác tương ứng với thuộc tính của BaoCaoHoatDong)

        tableViewKetQua.getColumns().addAll(colMaNhanVien, colTenNhanVien,
                new TableColumn<>("Mã Người Mượn"), new TableColumn<>("Tên Người Mượn"),
                new TableColumn<>("Mã Tài Liệu"), new TableColumn<>("Tên Tài Liệu"),
                new TableColumn<>("Mã Bản Sao"), new TableColumn<>("Hoạt Động"),
                new TableColumn<>("Mã Phiếu Phạt"), new TableColumn<>("Số Tiền Phạt"),
                new TableColumn<>("Lý Do Phạt")
        ); // Thêm các cột còn lại

        LocalDate ngay = datePicker.getValue();
        String ma = tfMa.getText();

        baoCaoList.clear();
        try {
            ObservableList<BaoCaoHoatDong> data; // ObservableList<BaoCaoHoatDong> để chứa dữ liệu báo cáo
            if (rbNguoiMuon.isSelected()) {
                data = NguoiMuonDAO.baoCaoHoatDongNguoiMuonTrongNgay(ma, ngay);
            } else if (rbNhanVien.isSelected()) {
                data = NhanVienDAO.baoCaoHoatDongNhanVienTrongNgay(ma, ngay);
            } else {
                throw new IllegalArgumentException("Vui lòng chọn loại báo cáo (Người mượn hoặc Nhân viên).");
            }

            tableViewKetQua.setItems(data); // Thiết lập dữ liệu cho TableView
        } catch (SQLException | IllegalArgumentException e) {
            e.printStackTrace();
            // Xử lý lỗi (hiển thị thông báo lỗi, ...)
        }
    }

    @SuppressWarnings("unchecked") // Bỏ qua cảnh báo unchecked cast
    private void setTableViewItems(ObservableList<?> items, String... propertyNames) {
        tableViewKetQua.getColumns().clear();
        for (String propertyName : propertyNames) {
            TableColumn<Object, Object> column = new TableColumn<>(propertyName);
            column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
            tableViewKetQua.getColumns().add(column);
        }
        tableViewKetQua.setItems((ObservableList<Object>) items); // Ép kiểu tại đây
    }

}
