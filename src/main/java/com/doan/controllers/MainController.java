package com.doan.controllers;

import com.doan.dao.*;
import com.doan.models.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

    private ObservableList<TaiLieu> taiLieuList;
    private ObservableList<BanSao> banSaoList;
    private ObservableList<TaiLieuQuaHan> taiLieuQuaHanList;
    private ObservableList<ThongKe> thongKeList;
    private ObservableList<BaoCaoHoatDong> baoCaoHoatDongList;
    private ObservableList<NguoiMuon> nguoiMuonList;
    private TraCuuTaiLieuController traCuuTaiLieuController;
    private TraCuuBanSaoController traCuuBanSaoController;
    private MuonTraTaiLieuController muonTraTaiLieuController;
    private ThongKeController thongKeController;
    private TaiLieuQuaHanController taiLieuQuaHanController;
    private BaoCaoHoatDongController baoCaoHoatDongController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Khởi tạo các ObservableList
        taiLieuList = FXCollections.observableArrayList();
        banSaoList = FXCollections.observableArrayList();
        nguoiMuonList = FXCollections.observableArrayList();
        taiLieuQuaHanList = FXCollections.observableArrayList();
        thongKeList = FXCollections.observableArrayList();
        baoCaoHoatDongList = FXCollections.observableArrayList();
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

        // Khởi tạo các cột của TableView
        traCuuTaiLieuController.initialize(loader.getLocation(), loader.getResources());


        // Xử lý tìm kiếm tài liệu
        Button btnTimKiem = (Button) layout.lookup("#btnTimKiem");
        btnTimKiem.setOnAction(event -> {
            traCuuTaiLieuController.traCuu();
        });
    }

    @FXML
    private void handleTaiLieuQuaHan() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/TaiLieuQuaHan.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);

        TaiLieuQuaHanController taiLieuQuaHanController = loader.getController();
        taiLieuQuaHanController.setMainController(this);

        // Khởi tạo các cột của TableView
        taiLieuQuaHanController.initialize(loader.getLocation(), loader.getResources());

        Button btnTraCuu = (Button) layout.lookup("#btnTraCuu");
        btnTraCuu.setOnAction(event -> {
            taiLieuQuaHanController.loadData();
        });
    }

    @FXML
    private void handleThongTinBanSao() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/TraCuuBanSao.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);

        TraCuuBanSaoController traCuuBanSaoController = loader.getController();
        traCuuBanSaoController.setMainController(this);

        traCuuBanSaoController.initialize(loader.getLocation(), loader.getResources());
        // Xử lý tìm kiếm bản sao
        Button btnTimKiem = (Button) layout.lookup("#btnTimKiem");
        btnTimKiem.setOnAction(event -> {
            traCuuBanSaoController.traCuu();
        });
    }

    @FXML
    private void handleBaoCaoHoatDong() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/BaoCaoHoatDong.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);
        BaoCaoHoatDongController baoCaoHoatDongController = loader.getController();
        baoCaoHoatDongController.setMainController(this);
        baoCaoHoatDongController.initialize(loader.getLocation(), loader.getResources());

        Button btnBaoCao = (Button) layout.lookup("#btnBaoCao");
        btnBaoCao.setOnAction(event -> {
            baoCaoHoatDongController.handleBaoCao();
        });
    }
    @FXML
    private void handleMuonTraTaiLieu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/MuonTraTaiLieu.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);
        MuonTraTaiLieuController muonTraTaiLieuController = loader.getController();
        muonTraTaiLieuController.setMainController(this);

        Button btnMuon = (Button) layout.lookup("#btnMuon");
        Button btnTra = (Button) layout.lookup("#btnTra");


        // Xử lý mượn tài liệu
        btnMuon.setOnAction(event -> {
            muonTraTaiLieuController.handleMuonTaiLieu();
        });

        // Xử lý trả tài liệu
        btnTra.setOnAction(event -> {
            muonTraTaiLieuController.handleTraTaiLieu();
        });

    }


    @FXML
    private void handleThongKe() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/ThongKe.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);

        ThongKeController thongKeTaiLieuController = loader.getController();
        thongKeTaiLieuController.setMainController(this);

        thongKeTaiLieuController.initialize(loader.getLocation(), loader.getResources());


        Button btnThongKeTatCaTL = (Button) layout.lookup("#btnThongKeTatCaTL");
        Button btnThongKeTLMuon = (Button) layout.lookup("#btnThongKeTLMuon");

        btnThongKeTatCaTL.setOnAction(event -> {
            thongKeTaiLieuController.thongKeTatca();
        });

        btnThongKeTLMuon.setOnAction(actionEvent -> {
            thongKeTaiLieuController.thongKeMuon();
        });
    }


}
