package com.doan.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ThongKeMuonTheoLoai {
    private StringProperty maLoaiTL;
    private StringProperty tenLoaiTL;
    private IntegerProperty soLuongMuon;

    public ThongKeMuonTheoLoai() {
        this.maLoaiTL = new SimpleStringProperty();
        this.tenLoaiTL = new SimpleStringProperty();
        this.soLuongMuon = new SimpleIntegerProperty();
    }

    // Getters & Setters
    public String getMaLoaiTL() { return maLoaiTL.get(); }
    public void setMaLoaiTL(String maLoaiTL) { this.maLoaiTL.set(maLoaiTL); }

    public String getTenLoaiTL() { return tenLoaiTL.get(); }
    public void setTenLoaiTL(String tenLoaiTL) { this.tenLoaiTL.set(tenLoaiTL); }

    public int getSoLuongMuon() { return soLuongMuon.get(); }
    public void setSoLuongMuon(int soLuongMuon) { this.soLuongMuon.set(soLuongMuon); }

    // Property methods
    public StringProperty getMaLoaiTLProperty() { return maLoaiTL; }
    public StringProperty getTenLoaiTLProperty() { return tenLoaiTL; }
    public IntegerProperty getSoLuongMuonProperty() { return soLuongMuon; }
}
