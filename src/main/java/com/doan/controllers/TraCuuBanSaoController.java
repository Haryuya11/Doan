package com.doan.controllers;

import com.doan.dao.BanSaoDAO;
import com.doan.models.BanSao;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.Normalizer;
import java.util.ResourceBundle;

public class TraCuuBanSaoController implements Initializable {

    @FXML
    private TextField tfMaTaiLieu;
    @FXML
    private Button btnTimKiem;
    @FXML
    private TableView<BanSao> tableViewKetQua;
    @FXML
    private TableColumn<BanSao, String> colMaTaiLieu;
    @FXML
    private TableColumn<BanSao, String> colMaBanSao;
    @FXML
    private TableColumn<BanSao, String> colTrangThai;
    @FXML
    private TableColumn<BanSao, String> colViTri;
//    @FXML
//    private ComboBox<String> trangThaiComboBox;

    private ObservableList<BanSao> banSaoList = FXCollections.observableArrayList();
    private MainController mainController; // Thêm thuộc tính mainController

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Khởi tạo các cột của TableView
        colMaTaiLieu.setCellValueFactory(new PropertyValueFactory<>("maTaiLieu"));
        colMaBanSao.setCellValueFactory(new PropertyValueFactory<>("maBanSao"));
        colTrangThai.setCellValueFactory(new PropertyValueFactory<>("trangThai"));
        colViTri.setCellValueFactory(cellData ->
                new SimpleStringProperty(
                        cellData.getValue().getSoPhong() + " - " +
                                cellData.getValue().getSoKe() + " - " +
                                cellData.getValue().getSoNgan()
                )
        );

//        tableViewKetQua.setItems(banSaoList);
//        tableViewKetQua.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//        trangThaiComboBox.getItems().addAll("Tất cả", "Có sẵn", "Đang được mượn", "Đã làm mất");
//        trangThaiComboBox.setValue("Tất cả"); // Mặc định là "Tất cả"
    }


}
