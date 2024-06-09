package com.doan.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TaiLieu {
    private StringProperty maTaiLieu;
    private StringProperty tenTaiLieu;
    private StringProperty tacGia;
    private StringProperty ngonNgu;
    private IntegerProperty soTrang;
    private StringProperty maLoaiTL;
    private StringProperty tenLoaiTL;
    private StringProperty gia;
    private IntegerProperty soLuong;
    private StringProperty viTri;


    // Constructor
    public TaiLieu() {
        this.maTaiLieu = new SimpleStringProperty();
        this.tenTaiLieu = new SimpleStringProperty();
        this.tacGia = new SimpleStringProperty();
        this.ngonNgu = new SimpleStringProperty();
        this.soTrang = new SimpleIntegerProperty();
        this.maLoaiTL = new SimpleStringProperty();
        this.tenLoaiTL = new SimpleStringProperty();
        this.gia = new SimpleStringProperty();
        this.soLuong = new SimpleIntegerProperty();
        this.viTri = new SimpleStringProperty();
    }

    // Getters & Setters
    public String getMaTaiLieu() {
        return maTaiLieu.get();
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu.set(maTaiLieu);
    }

    public String getTenTaiLieu() {
        return tenTaiLieu.get();
    }

    public void setTenTaiLieu(String tenTaiLieu) {
        this.tenTaiLieu.set(tenTaiLieu);
    }

    public String getTacGia() {
        return tacGia.get();
    }

    public void setTacGia(String tacGia) {
        this.tacGia.set(tacGia);
    }

    public String getNgonNgu() {
        return ngonNgu.get();
    }

    public void setNgonNgu(String ngonNgu) {
        this.ngonNgu.set(ngonNgu);
    }

    public int getSoTrang() {
        return soTrang.get();
    }

    public void setSoTrang(int soTrang) {
        this.soTrang.set(soTrang);
    }

    public String getMaLoaiTL() {
        return maLoaiTL.get();
    }

    public void setMaLoaiTL(String maLoaiTL) {
        this.maLoaiTL.set(maLoaiTL);
    }

    public String getTenLoaiTL() {
        return tenLoaiTL.get();
    }

    public void setTenLoaiTL(String tenLoaiTL) {
        this.tenLoaiTL.set(tenLoaiTL);
    }

    public String getGia() {
        return gia.get();
    }

    public void setGia(String gia) {
        this.gia.set(gia);
    }

    public int getSoLuong() {
        return soLuong.get();
    }

    public void setSoLuong(int soLuong) {
        this.soLuong.set(soLuong);
    }

    public String getViTri() {
        return viTri.get();
    }

    public void setViTri(String viTri) {
        this.viTri.set(viTri);
    }

    // Property methods
    public StringProperty getMaTaiLieuProperty() {
        return maTaiLieu;
    }

    public StringProperty getTenTaiLieuProperty() {
        return tenTaiLieu;
    }

    public StringProperty getTacGiaProperty() {
        return tacGia;
    }

    public StringProperty getNgonNguProperty() {
        return ngonNgu;
    }

    public IntegerProperty getSoTrangProperty() {
        return soTrang;
    }

    public StringProperty getMaLoaiTLProperty() {
        return maLoaiTL;
    }

    public StringProperty getTenLoaiTLProperty() {
        return tenLoaiTL;
    }

    public StringProperty getGiaProperty() {
        return gia;
    }

    public IntegerProperty getSoLuongProperty() {
        return soLuong;
    }

    public StringProperty getViTriProperty() {
        return viTri;
    }
}
