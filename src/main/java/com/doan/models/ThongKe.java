package com.doan.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ThongKe {
    private StringProperty tenLoaiTL;
    private IntegerProperty soLuong;

    public ThongKe() {
        this.tenLoaiTL = new SimpleStringProperty();
        this.soLuong = new SimpleIntegerProperty();
    }

    // Getters & Setters
    public String getTenLoaiTL() {
        return tenLoaiTL.get();
    }

    public void setTenLoaiTL(String tenLoaiTL) {
        this.tenLoaiTL.set(tenLoaiTL);
    }

    public int getSoLuong() {
        return soLuong.get();
    }

    public void setSoLuong(int soLuong) {
        this.soLuong.set(soLuong);
    }

    // Property methods
    public StringProperty getTenLoaiTLProperty() {
        return tenLoaiTL;
    }

    public IntegerProperty getSoLuongProperty() {
        return soLuong;
    }
}
