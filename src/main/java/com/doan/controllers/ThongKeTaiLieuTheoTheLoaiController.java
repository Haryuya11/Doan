package com.doan.controllers;

import com.doan.dao.TaiLieuDAO;
import com.doan.models.TaiLieu;
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
    private TableView<TaiLieu> tableViewThongKeTaiLieuTheoTheLoai;
    @FXML
    private TableColumn<TaiLieu, String> colTenLoai;
    @FXML
    private TableColumn<TaiLieu, Integer> colSoLuong;
    @FXML
    private VBox layout;

    private MainController mainController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Khởi tạo các cột
        colTenLoai.setCellValueFactory(new PropertyValueFactory<>("tenLoaiTL"));
        colSoLuong.setCellValueFactory(new PropertyValueFactory<>("soLuong"));

        // Lấy dữ liệu và hiển thị
        ObservableList<TaiLieu> data = TaiLieuDAO.thongKeTaiLieuTheoTheLoai();
        tableViewThongKeTaiLieuTheoTheLoai.setItems(data);
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public VBox getLayout() {
        return layout;
    }
}
