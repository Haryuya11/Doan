package com.doan.controllers;

import com.doan.dao.TaiLieuDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import com.doan.models.ThongKe;

import java.net.URL;
import java.util.ResourceBundle;

public class ThongKeController implements Initializable {
    @FXML
    private TableView<ThongKe> tableViewKetQua;
    @FXML
    private TableColumn<ThongKe, String> colTenLoai;
    @FXML
    private TableColumn<ThongKe, Integer> colSoLuong;


    private MainController mainController;
    private ObservableList<ThongKe> thongKeList = FXCollections.observableArrayList(); // Tạo ObservableList<TaiLieu>

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Khởi tạo các cột
        colTenLoai.setCellValueFactory(new PropertyValueFactory<>("tenLoaiTL"));
        colSoLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));
        tableViewKetQua.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

    @FXML
    private void thongKeTatca() {
        thongKeList.clear();
        thongKeList.addAll(TaiLieuDAO.thongKeTaiLieuTheoTheLoai());
        tableViewKetQua.setItems(thongKeList);
        tableViewKetQua.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

    @FXML
    private void thongKeMuon() {
        thongKeList.clear();
        thongKeList.addAll(TaiLieuDAO.thongKeMuonTheoLoai());
        tableViewKetQua.setItems(thongKeList);
        tableViewKetQua.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }
    public TableView<ThongKe> getTableViewKetQua() {
        return tableViewKetQua;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
