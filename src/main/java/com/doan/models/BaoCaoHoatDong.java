package com.doan.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BaoCaoHoatDong {
    private StringProperty maNhanVien;
    private StringProperty tenNhanVien;
    private StringProperty maNguoiMuon;
    private StringProperty tenNguoiMuon;
    private StringProperty maTaiLieu;
    private StringProperty tenTaiLieu;
    private StringProperty maBanSao;
    private StringProperty hoatDong;
    private StringProperty maPhieuPhat;
    private StringProperty soTienPhat;
    private StringProperty lyDoPhat;

    // Constructor
    public BaoCaoHoatDong() {
        this.maNhanVien = new SimpleStringProperty();
        this.tenNhanVien = new SimpleStringProperty();
        this.maNguoiMuon = new SimpleStringProperty();
        this.tenNguoiMuon = new SimpleStringProperty();
        this.maTaiLieu = new SimpleStringProperty();
        this.tenTaiLieu = new SimpleStringProperty();
        this.maBanSao = new SimpleStringProperty();
        this.hoatDong = new SimpleStringProperty();
        this.maPhieuPhat = new SimpleStringProperty();
        this.soTienPhat = new SimpleStringProperty();
        this.lyDoPhat = new SimpleStringProperty();
    }

    // Getters and Setters
    public String getMaNhanVien() { return maNhanVien.get(); }
    public void setMaNhanVien(String maNhanVien) { this.maNhanVien.set(maNhanVien); }

    public String getTenNhanVien() { return tenNhanVien.get(); }
    public void setTenNhanVien(String tenNhanVien) { this.tenNhanVien.set(tenNhanVien); }

    public String getMaNguoiMuon() { return maNguoiMuon.get(); }
    public void setMaNguoiMuon(String maNguoiMuon) { this.maNguoiMuon.set(maNguoiMuon); }

    public String getTenNguoiMuon() { return tenNguoiMuon.get(); }
    public void setTenNguoiMuon(String tenNguoiMuon) { this.tenNguoiMuon.set(tenNguoiMuon); }

    public String getMaTaiLieu() { return maTaiLieu.get(); }
    public void setMaTaiLieu(String maTaiLieu) { this.maTaiLieu.set(maTaiLieu); }

    public String getTenTaiLieu() { return tenTaiLieu.get(); }
    public void setTenTaiLieu(String tenTaiLieu) { this.tenTaiLieu.set(tenTaiLieu); }

    public String getMaBanSao() { return maBanSao.get(); }
    public void setMaBanSao(String maBanSao) { this.maBanSao.set(maBanSao); }

    public String getHoatDong() { return hoatDong.get(); }
    public void setHoatDong(String hoatDong) { this.hoatDong.set(hoatDong); }

    public String getMaPhieuPhat() { return maPhieuPhat.get(); }
    public void setMaPhieuPhat(String maPhieuPhat) { this.maPhieuPhat.set(maPhieuPhat); }

    public String getSoTienPhat() { return soTienPhat.get(); }
    public void setSoTienPhat(String soTienPhat) { this.soTienPhat.set(soTienPhat); }

    public String getLyDoPhat() { return lyDoPhat.get(); }
    public void setLyDoPhat(String lyDoPhat) { this.lyDoPhat.set(lyDoPhat); }

    // Property methods
    public StringProperty maNhanVienProperty() { return maNhanVien; }
    public StringProperty tenNhanVienProperty() { return tenNhanVien; }
    public StringProperty maNguoiMuonProperty() { return maNguoiMuon; }
    public StringProperty tenNguoiMuonProperty() { return tenNguoiMuon; }
    public StringProperty maTaiLieuProperty() { return maTaiLieu; }
    public StringProperty tenTaiLieuProperty() { return tenTaiLieu; }
    public StringProperty maBanSaoProperty() { return maBanSao; }
    public StringProperty hoatDongProperty() { return hoatDong; }
    public StringProperty maPhieuPhatProperty() { return maPhieuPhat; }
    public StringProperty soTienPhatProperty() { return soTienPhat; }
    public StringProperty lyDoPhatProperty() { return lyDoPhat; }
}
