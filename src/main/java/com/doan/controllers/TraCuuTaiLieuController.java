package com.doan.controllers;

import com.doan.dao.TaiLieuDAO;
import com.doan.models.TaiLieu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class TraCuuTaiLieuController implements Initializable {

    @FXML
    private TextField tfTuKhoa;
    @FXML
    private TableView<TaiLieu> tableViewKetQua;
    @FXML
    private TableColumn<TaiLieu, String> colMaTaiLieu;
    @FXML
    private TableColumn<TaiLieu, String> colTenTaiLieu;
    @FXML
    private TableColumn<TaiLieu, String> colTacGia;
    @FXML
    private TableColumn<TaiLieu, String> colNgonNgu;
    @FXML
    private TableColumn<TaiLieu, String> colTheLoai;
    @FXML
    private TableColumn<TaiLieu, Integer> colSoLuong;
    private MainController mainController;
    private ObservableList<TaiLieu> taiLieuList = FXCollections.observableArrayList(); // Tạo ObservableList<TaiLieu>

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Khởi tạo các cột của TableView
        colMaTaiLieu.setCellValueFactory(new PropertyValueFactory<>("maTaiLieu"));
        colTenTaiLieu.setCellValueFactory(new PropertyValueFactory<>("tenTaiLieu"));
        colTacGia.setCellValueFactory(new PropertyValueFactory<>("tacGia"));
        colNgonNgu.setCellValueFactory(new PropertyValueFactory<>("ngonNgu"));
        colTheLoai.setCellValueFactory(new PropertyValueFactory<>("tenLoaiTL"));
        colSoLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
        tableViewKetQua.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

    public void traCuu(){
        String tuKhoa = tfTuKhoa.getText();
        taiLieuList.clear();
        taiLieuList.addAll(TaiLieuDAO.timKiemTaiLieu(tuKhoa));
        tableViewKetQua.setItems(taiLieuList);
        tableViewKetQua.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    // Thêm phương thức getTableViewKetQua
    public TableView<TaiLieu> getTableViewKetQua() {
        return tableViewKetQua;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
