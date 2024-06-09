package com.doan.controllers;

import com.doan.dao.BanSaoDAO;
import com.doan.dao.NguoiMuonDAO;
import com.doan.dao.TaiLieuDAO;
import com.doan.models.BanSao;
import com.doan.models.NguoiMuon;
import com.doan.models.TaiLieu;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Label lblTenNhanVien;
    @FXML
    private Label lblMaNhanVien;
    @FXML
    private Label lblNgayGio;
    @FXML
    private VBox contentArea;
    @FXML
    private TableView<TaiLieu> tableViewKetQua;

    private ObservableList<BanSao> banSaoList;
    private ObservableList<NguoiMuon> nguoiMuonList;

    private TraCuuTaiLieuController traCuuTaiLieuController;
    private ObservableList<TaiLieu> taiLieuList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Khởi tạo các ObservableList
        taiLieuList = FXCollections.observableArrayList();
        banSaoList = FXCollections.observableArrayList();
        nguoiMuonList = FXCollections.observableArrayList();

        // Khởi tạo các cột cho tableViewKetQua (có thể để trống lúc đầu)
    }

    public void setThongTinNhanVien(String tenNhanVien, String maNhanVien) {
        lblTenNhanVien.setText(tenNhanVien);
        lblMaNhanVien.setText(maNhanVien);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        lblNgayGio.setText(formattedDateTime);
    }

    @FXML
    private void handleThongTinTaiLieu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/TraCuuTaiLieu.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);

        TraCuuTaiLieuController traCuuTaiLieuController = loader.getController();
        traCuuTaiLieuController.setMainController(this); // Thiết lập tham chiếu đến MainController

        // Lấy các thành phần giao diện từ layout
        TextField tfTuKhoa = (TextField) layout.lookup("#tfTuKhoa");
        TableView<TaiLieu> tableViewTaiLieu = (TableView<TaiLieu>) layout.lookup("#tableViewKetQua");

        // Khởi tạo các cột của TableView
        TableColumn<TaiLieu, String> colMaTaiLieu = new TableColumn<>("Mã Tài Liệu");
        colMaTaiLieu.setCellValueFactory(new PropertyValueFactory<>("maTaiLieu"));
        TableColumn<TaiLieu, String> colTenTaiLieu = new TableColumn<>("Tên Tài Liệu");
        colTenTaiLieu.setCellValueFactory(new PropertyValueFactory<>("tenTaiLieu"));
        TableColumn<TaiLieu, String> colTacGia = new TableColumn<>("Tác Giả");
        colTacGia.setCellValueFactory(new PropertyValueFactory<>("tacGia"));
        TableColumn<TaiLieu, String> colNgonNgu = new TableColumn<>("Ngôn Ngữ");
        colNgonNgu.setCellValueFactory(new PropertyValueFactory<>("ngonNgu"));
        TableColumn<TaiLieu, String> colTheLoai = new TableColumn<>("Thể Loại");
        colTheLoai.setCellValueFactory(new PropertyValueFactory<>("tenLoaiTL")); // Sử dụng tenLoaiTL
        TableColumn<TaiLieu, Integer> colSoLuong = new TableColumn<>("Số Lượng");
        colSoLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));

//        tableViewTaiLieu.getColumns().addAll(colMaTaiLieu, colTenTaiLieu, colTacGia, colNgonNgu, colTheLoai, colSoLuong);

        // Xử lý tìm kiếm tài liệu
        Button btnTimKiem = (Button) layout.lookup("#btnTimKiem");
        btnTimKiem.setOnAction(event -> {
            String tuKhoa = tfTuKhoa.getText();
            taiLieuList.clear();
            taiLieuList.addAll(TaiLieuDAO.timKiemTaiLieu(tuKhoa));
            tableViewTaiLieu.setItems(taiLieuList);
        });
    }


    @FXML
    private void handleThongTinBanSao() throws IOException {
        // ... (Tương tự như handleThongTinTaiLieu, nhưng tải layout TraCuuBanSao.fxml và thiết lập các cột cho TableView<BanSao>)
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/TraCuuBanSao.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);

        TraCuuBanSaoController traCuuBanSaoController = loader.getController();
        traCuuBanSaoController.setMainController(this);

        TextField tfMaTaiLieu = (TextField) layout.lookup("#tfMaTaiLieu");
        TableView<BanSao> tableViewBanSao = (TableView<BanSao>) layout.lookup("#tableViewKetQua");

        // Khởi tạo các cột của TableView
        TableColumn<BanSao, String> colMaTaiLieu = new TableColumn<>("Mã Tài Liệu");
        colMaTaiLieu.setCellValueFactory(new PropertyValueFactory<>("maTaiLieu"));
        TableColumn<BanSao, String> colMaBanSao = new TableColumn<>("Mã Bản Sao");
        colMaBanSao.setCellValueFactory(new PropertyValueFactory<>("maBanSao"));
        TableColumn<BanSao, String> colTrangThai = new TableColumn<>("Trạng Thái");
        colTrangThai.setCellValueFactory(new PropertyValueFactory<>("trangThai"));
        TableColumn<BanSao, String> colViTri = new TableColumn<>("Vị Trí");
        colViTri.setCellValueFactory(cellData ->
                new SimpleStringProperty(
                        cellData.getValue().getSoPhong() + " - " +
                                cellData.getValue().getSoKe() + " - " +
                                cellData.getValue().getSoNgan()
                )
        );

//        tableViewBanSao.getColumns().addAll(colMaTaiLieu, colMaBanSao, colTrangThai, colViTri);

        // Xử lý tìm kiếm bản sao
        Button btnTimKiem = (Button) layout.lookup("#btnTimKiem");
        btnTimKiem.setOnAction(event -> {
            String maTaiLieu = tfMaTaiLieu.getText();
            banSaoList.clear();
            banSaoList.addAll(BanSaoDAO.layThongTinBanSao(maTaiLieu, null));
            tableViewBanSao.setItems(banSaoList);
        });
    }

    @FXML
    private void handleMuonTraTaiLieu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/MuonTraTaiLieu.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);
        MuonTraTaiLieuController muonTraTaiLieuController = loader.getController();
        muonTraTaiLieuController.setMainController(this);
    }

//    @FXML
//    private void handleThongKeBaoCao() throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/ThongKeBaoCao.fxml"));
//        VBox layout = loader.load();
//        contentArea.getChildren().setAll(layout);
//
//        ThongKeBaoCaoController thongKeBaoCaoController = loader.getController();
//        thongKeBaoCaoController.setMainController(this);
//    }
}
