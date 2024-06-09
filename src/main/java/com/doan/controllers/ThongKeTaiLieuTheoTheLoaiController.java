package com.doan.controllers;

import com.doan.dao.TaiLieuDAO;
import com.doan.models.TaiLieu;
import com.doan.models.ThongKeTaiLieuTheoTheLoai;
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

public class ThongKeTaiLieuTheoTheLoaiController implements Initializable {
    @FXML
    private TableView<ThongKeTaiLieuTheoTheLoai> tableViewKetQua;
    @FXML
    private TableColumn<ThongKeTaiLieuTheoTheLoai, String> colTenLoai;
    @FXML
    private TableColumn<ThongKeTaiLieuTheoTheLoai, Integer> colSoLuong;


    private MainController mainController;
    private ObservableList<ThongKeTaiLieuTheoTheLoai> thongKeTaiLieuTheoTheLoaiList = FXCollections.observableArrayList(); // Tạo ObservableList<TaiLieu>
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Khởi tạo các cột
        colTenLoai.setCellValueFactory(new PropertyValueFactory<>("tenLoaiTL"));
        colSoLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));

        // Lấy dữ liệu và hiển thị
        tableViewKetQua.setItems(thongKeTaiLieuTheoTheLoaiList);
        tableViewKetQua.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public TableView<ThongKeTaiLieuTheoTheLoai> getTableViewKetQua() {
        return tableViewKetQua;
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
