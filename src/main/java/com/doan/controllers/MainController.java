package com.doan.controllers;

import com.doan.models.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void setThongTinNhanVien(String tenNhanVien, String maNhanVien) {
        lblTenNhanVien.setText(tenNhanVien);
        lblMaNhanVien.setText(maNhanVien);

        Timeline timeline;
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss");
            String formattedDateTime = LocalDateTime.now().format(formatter);
            lblNgayGio.setText(formattedDateTime);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE); // Lặp lại vô hạn
        timeline.play(); // Bắt đầu Timeline
    }

    @FXML
    private void handleThongTinTaiLieu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/TraCuuTaiLieu.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);

        TraCuuTaiLieuController traCuuTaiLieuController = loader.getController();
        traCuuTaiLieuController.setMainController(this); // Thiết lập tham chiếu đến MainController
    }

    @FXML
    private void handleTaiLieuQuaHan() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/TaiLieuQuaHan.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);

        TaiLieuQuaHanController taiLieuQuaHanController = loader.getController();
        taiLieuQuaHanController.setMainController(this);

    }

    @FXML
    private void handleThongTinBanSao() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/TraCuuBanSao.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);

        TraCuuBanSaoController traCuuBanSaoController = loader.getController();
        traCuuBanSaoController.setMainController(this);
    }

    @FXML
    private void handleBaoCaoHoatDong() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/BaoCaoHoatDong.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);

        BaoCaoHoatDongController baoCaoHoatDongController = loader.getController();
        baoCaoHoatDongController.setMainController(this);
    }
    @FXML
    private void handleMuonTraTaiLieu() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/MuonTraTaiLieu.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);

        MuonTraTaiLieuController muonTraTaiLieuController = loader.getController();
        muonTraTaiLieuController.setMainController(this);

    }

    @FXML
    private void handleThongKe() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/ThongKe.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);

        ThongKeController thongKeTaiLieuController = loader.getController();
        thongKeTaiLieuController.setMainController(this);
    }

    @FXML
    public void handleLichSuNguoiMuon() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/LichSuNguoiMuon.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);

        LichSuNguoiMuonController lichSuNguoiMuonController = loader.getController();
        lichSuNguoiMuonController.setMainController(this);
    }

    @FXML
    public void handleTraCuuPhieuPhat() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/TraCuuPhieuPhat.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);

        TraCuuPhieuPhatController traCuuPhieuPhatController = loader.getController();
        traCuuPhieuPhatController.setMainController(this);
    }
}
