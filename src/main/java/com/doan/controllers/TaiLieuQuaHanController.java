package com.doan.controllers;

import com.doan.dao.TaiLieuDAO;
import com.doan.models.TaiLieu;
import com.doan.models.TaiLieuQuaHan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class TaiLieuQuaHanController implements Initializable {

    @FXML
    private TableView<TaiLieuQuaHan> tableViewKetQua; // Sửa kiểu dữ liệu của TableView
    @FXML
    private TableColumn<TaiLieuQuaHan, String> colMaSo;
    @FXML
    private TableColumn<TaiLieuQuaHan, String> colHoTen;
    @FXML
    private TableColumn<TaiLieuQuaHan, String> colMaTaiLieu;
    @FXML
    private TableColumn<TaiLieuQuaHan, String> colTenTaiLieu;
    @FXML
    private TableColumn<TaiLieuQuaHan, String> colHanTra;
    @FXML
    private TableColumn<TaiLieuQuaHan, Integer> colSoNgayQuaHan;

    private MainController mainController;
    private ObservableList<TaiLieuQuaHan> taiLieuQuaHanList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Khởi tạo các cột của TableView
        colMaSo.setCellValueFactory(new PropertyValueFactory<>("maSo"));
        colHoTen.setCellValueFactory(new PropertyValueFactory<>("hoTen"));
        colMaTaiLieu.setCellValueFactory(new PropertyValueFactory<>("maTaiLieu"));
        colTenTaiLieu.setCellValueFactory(new PropertyValueFactory<>("tenTaiLieu"));
        colHanTra.setCellValueFactory(new PropertyValueFactory<>("hanTra"));
        colSoNgayQuaHan.setCellValueFactory(new PropertyValueFactory<>("soNgayQuaHan"));
        tableViewKetQua.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

    @FXML
    private void traCuu() {
        taiLieuQuaHanList.clear();
        taiLieuQuaHanList.addAll(TaiLieuDAO.taiLieuQuaHan());
        tableViewKetQua.setItems(taiLieuQuaHanList);
        tableViewKetQua.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public TableView<TaiLieuQuaHan> getTableViewKetQua() {
        return tableViewKetQua;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
