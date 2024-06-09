package com.doan.controllers;

import com.doan.dao.TaiLieuDAO;
import com.doan.models.TaiLieu;
import com.doan.models.ThongKeMuonTheoLoai;
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

public class ThongKeMuonTheoLoaiController implements Initializable {
    @FXML
    private TableView<ThongKeMuonTheoLoai> tableViewKetQua;
    @FXML
    private TableColumn<ThongKeMuonTheoLoai, String> colMaLoai;
    @FXML
    private TableColumn<ThongKeMuonTheoLoai, String> colTenLoai;
    @FXML
    private TableColumn<ThongKeMuonTheoLoai, Integer> colSoLuongMuon;


    private MainController mainController;
    private ObservableList<ThongKeMuonTheoLoai> thongKeMuonTheoLoaisList = FXCollections.observableArrayList(); // Tạo ObservableList<TaiLieu>
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Khởi tạo các cột
        colMaLoai.setCellValueFactory(new PropertyValueFactory<>("maLoaiTL"));
        colTenLoai.setCellValueFactory(new PropertyValueFactory<>("tenLoaiTL"));
        colSoLuongMuon.setCellValueFactory(new PropertyValueFactory<>("soLuongMuon"));

        // Lấy dữ liệu và hiển thị
        tableViewKetQua.setItems(thongKeMuonTheoLoaisList);
        tableViewKetQua.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }

    public TableView<ThongKeMuonTheoLoai> getTableViewKetQua() {
        return tableViewKetQua;
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

}
