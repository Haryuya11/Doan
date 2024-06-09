package com.doan.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class NhanVien {
    private StringProperty maNV;
    private StringProperty tenNV;
    private StringProperty sdt;

    public NhanVien() {
        this.maNV = new SimpleStringProperty();
        this.tenNV = new SimpleStringProperty();
        this.sdt = new SimpleStringProperty();
    }

    // Getters & Setters
    public String getMaNV() { return maNV.get(); }
    public void setMaNV(String maNV) { this.maNV.set(maNV); }
    public String getTenNV() { return tenNV.get(); }
    public void setTenNV(String tenNV) { this.tenNV.set(tenNV); }
    public String getSdt() { return sdt.get(); }
    public void setSdt(String sdt) { this.sdt.set(sdt); }

    // Property methods
    public StringProperty getMaNVProperty() { return maNV; }
    public StringProperty getTenNVProperty() { return tenNV; }
    public StringProperty getSdtProperty() { return sdt; }
}
