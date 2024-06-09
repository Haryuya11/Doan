package com.doan.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.time.LocalDate;

public class PhieuMuon {
    private StringProperty maTaiLieu;
    private StringProperty tenTaiLieu;
    private StringProperty maBanSao;
    private StringProperty tinhTrang;
    private ObjectProperty<LocalDate> ngayMuon;
    private ObjectProperty<LocalDate> hanTra;
    private ObjectProperty<LocalDate> ngayTra;

    // Constructor, getters, setters, property methods
    public PhieuMuon() {
        this.maTaiLieu = new SimpleStringProperty();
        this.tenTaiLieu = new SimpleStringProperty();
        this.maBanSao = new SimpleStringProperty();
        this.tinhTrang = new SimpleStringProperty();
        this.ngayMuon = new SimpleObjectProperty<>();
        this.hanTra = new SimpleObjectProperty<>();
        this.ngayTra = new SimpleObjectProperty<>();
    }

    // ... (Các getters và setters cho các thuộc tính)
    public String getMaTaiLieu() { return maTaiLieu.get(); }
    public void setMaTaiLieu(String maTaiLieu) { this.maTaiLieu.set(maTaiLieu); }

    public String getTenTaiLieu() { return tenTaiLieu.get(); }
    public void setTenTaiLieu(String tenTaiLieu) { this.tenTaiLieu.set(tenTaiLieu); }

    public String getMaBanSao() { return maBanSao.get(); }
    public void setMaBanSao(String maBanSao) { this.maBanSao.set(maBanSao); }

    public String getTinhTrang() { return tinhTrang.get(); }
    public void setTinhTrang(String tinhTrang) { this.tinhTrang.set(tinhTrang); }

    public LocalDate getNgayMuon() { return ngayMuon.get(); }
    public void setNgayMuon(LocalDate ngayMuon) { this.ngayMuon.set(ngayMuon); }

    public LocalDate getHanTra() { return hanTra.get(); }
    public void setHanTra(LocalDate hanTra) { this.hanTra.set(hanTra); }

    public LocalDate getNgayTra() { return ngayTra.get(); }
    public void setNgayTra(LocalDate ngayTra) { this.ngayTra.set(ngayTra); }

    // Property methods
    public StringProperty getMaTaiLieuProperty() { return maTaiLieu; }
    public StringProperty getTenTaiLieuProperty() { return tenTaiLieu; }
    public StringProperty getMaBanSaoProperty() { return maBanSao; }
    public StringProperty getTinhTrangProperty() { return tinhTrang; }
    public ObjectProperty<LocalDate> getNgayMuonProperty() { return ngayMuon; }
    public ObjectProperty<LocalDate> getHanTraProperty() { return hanTra; }
    public ObjectProperty<LocalDate> getNgayTraProperty() { return ngayTra; }
}
