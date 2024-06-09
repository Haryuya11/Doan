package com.doan.controllers;

import com.doan.dao.BanSaoDAO;
import com.doan.dao.NguoiMuonDAO;
import com.doan.dao.TaiLieuDAO;
import com.doan.models.*;
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

    private ObservableList<TaiLieu> taiLieuList;
    private ObservableList<BanSao> banSaoList;
    private ObservableList<TaiLieuQuaHan> taiLieuQuaHanList;
    private ObservableList<ThongKeMuonTheoLoai> thongKeMuonTheoLoaisList;
    private ObservableList<ThongKeTaiLieuTheoTheLoai> thongKeTaiLieuTheoTheLoaiList;
    private ObservableList<NguoiMuon> nguoiMuonList;
    private TraCuuTaiLieuController traCuuTaiLieuController;
    private TraCuuBanSaoController traCuuBanSaoController;
    private MuonTraTaiLieuController muonTraTaiLieuController;
    private ThongKeMuonTheoLoaiController thongKeMuonTheoLoaiController;
    private ThongKeTaiLieuTheoTheLoaiController thongKeTaiLieuTheoTheLoaiController;
    private TaiLieuQuaHanController taiLieuQuaHanController;
    private BaoCaoHoatDongController baoCaoHoatDongController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Khởi tạo các ObservableList
        taiLieuList = FXCollections.observableArrayList();
        banSaoList = FXCollections.observableArrayList();
        nguoiMuonList = FXCollections.observableArrayList();
        taiLieuQuaHanList = FXCollections.observableArrayList();
        thongKeMuonTheoLoaisList = FXCollections.observableArrayList();
        thongKeTaiLieuTheoTheLoaiList = FXCollections.observableArrayList();
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
    private void handleTaiLieuQuaHan() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/TaiLieuQuaHan.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);

        TaiLieuQuaHanController taiLieuQuaHanController = loader.getController();
        taiLieuQuaHanController.setMainController(this);

        // Khởi tạo các cột của TableView
        TableView<TaiLieuQuaHan> tableViewTaiLieuQH = (TableView<TaiLieuQuaHan>) layout.lookup("#tableViewKetQua");
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

        Button btnTraCuu = (Button) layout.lookup("#btnTraCuu");
        btnTraCuu.setOnAction(event -> {
            taiLieuQuaHanList.clear();
            taiLieuQuaHanList.addAll(TaiLieuDAO.taiLieuQuaHan());
            tableViewTaiLieuQH.setItems(taiLieuQuaHanList);
        });
    }

    @FXML
    private void handleThongKeMuonTheoLoai() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/ThongKeMuonTheoLoai.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);

        ThongKeMuonTheoLoaiController thongKeMuonTheoLoaiController = loader.getController();
        thongKeMuonTheoLoaiController.setMainController(this);

        TableView<ThongKeMuonTheoLoai> tableViewMuonTheoLoai = (TableView<ThongKeMuonTheoLoai>) layout.lookup("#tableViewKetQua");
        TableColumn<ThongKeMuonTheoLoai,String > colMaLoaiTl = new TableColumn<>("Mã Loại Tài Liệu");
        colMaLoaiTl.setCellValueFactory(new PropertyValueFactory<>("maLoaiTL"));
        TableColumn<ThongKeMuonTheoLoai,String > colTenLoaiTl = new TableColumn<>("Tên Loại Tài Liệu");
        colTenLoaiTl.setCellValueFactory(new PropertyValueFactory<>("tenLoaiTL"));
        TableColumn<ThongKeMuonTheoLoai,Integer > colSoLuongMuon = new TableColumn<>("Số Lượng Mượn");
        colSoLuongMuon.setCellValueFactory(new PropertyValueFactory<>("soLuongMuon"));

        Button btnThongKe = (Button) layout.lookup("#btnThongKe");
        btnThongKe.setOnAction(event -> {
            thongKeMuonTheoLoaisList.clear();
            thongKeMuonTheoLoaisList.addAll(TaiLieuDAO.thongKeMuonTheoLoai());
            tableViewMuonTheoLoai.setItems(thongKeMuonTheoLoaisList);
        });
    }

    @FXML
    private void handleThongKeTaiLieuTheoTheLoai() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/ThongKeTaiLieuTheoTheLoai.fxml"));
        VBox layout = loader.load();
        contentArea.getChildren().setAll(layout);

        ThongKeTaiLieuTheoTheLoaiController thongKeTaiLieuTheoTheLoaiController = loader.getController();
        thongKeTaiLieuTheoTheLoaiController.setMainController(this);

        TableView<ThongKeTaiLieuTheoTheLoai> tableViewTaiLieuTheoTheLoai = (TableView<ThongKeTaiLieuTheoTheLoai>) layout.lookup("#tableViewKetQua");
        TableColumn<ThongKeTaiLieuTheoTheLoai, String> colTenLoai = new TableColumn<>("Tên Loại Tài Liệu");
        colTenLoai.setCellValueFactory(new PropertyValueFactory<>("tenLoaiTL"));
        TableColumn<ThongKeTaiLieuTheoTheLoai, Integer> colSoLuong = new TableColumn<>("Số Lượng");
        colSoLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));

        Button btnThongKe = (Button) layout.lookup("#btnThongKe");
        btnThongKe.setOnAction(event -> {
            thongKeTaiLieuTheoTheLoaiList.clear();
            thongKeTaiLieuTheoTheLoaiList.addAll(TaiLieuDAO.thongKeTaiLieuTheoTheLoai());
            tableViewTaiLieuTheoTheLoai.setItems(thongKeTaiLieuTheoTheLoaiList);
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








    @FXML
    private void handleBaoCaoHoatDong() throws IOException {
        if (baoCaoHoatDongController == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/BaoCaoHoatDong.fxml"));
            VBox layout = loader.load();
            contentArea.getChildren().setAll(layout);

            baoCaoHoatDongController = loader.getController();
            baoCaoHoatDongController.setMainController(this);
        } else {
            contentArea.getChildren().setAll(baoCaoHoatDongController.getLayout());
        }
    }


//    @FXML
//    private void handleThongKeBaoCao() throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/doan/views/ThongKeBaoCao.fxml"));
//        VBox layout = loader.load();
//        contentArea.getChildren().setAll(layout);
//        ThongKeBaoCaoController thongKeBaoCaoController = loader.getController();
//        thongKeBaoCaoController.setMainController(this);
//        thongKeBaoCaoController.setTableViewKetQua(tableViewKetQua); // Thêm dòng này
//
//    }

}
