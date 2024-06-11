package com.doan.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TaiLieuQuaHan {
    private StringProperty maSo;
    private StringProperty hoTen;
    private StringProperty maTaiLieu;
    private StringProperty maBanSao;
    private StringProperty hanTra;
    private IntegerProperty soNgayQuaHan;

    // Constructor
    public TaiLieuQuaHan() {
        this.maSo = new SimpleStringProperty();
        this.hoTen = new SimpleStringProperty();
        this.maTaiLieu = new SimpleStringProperty();
        this.maBanSao = new SimpleStringProperty();
        this.hanTra = new SimpleStringProperty();
        this.soNgayQuaHan = new SimpleIntegerProperty();
    }

    // Getters & Setters
    public String getMaSo() { return maSo.get(); }
    public void setMaSo(String maSo) { this.maSo.set(maSo); }

    public String getHoTen() { return hoTen.get(); }
    public void setHoTen(String hoTen) { this.hoTen.set(hoTen); }

    public String getMaTaiLieu() { return maTaiLieu.get(); }
    public void setMaTaiLieu(String maTaiLieu) { this.maTaiLieu.set(maTaiLieu); }

    public String getMaBanSao() { return maBanSao.get(); }
    public void setMaBanSao(String maBanSao) { this.maBanSao.set(maBanSao); }

    public String getHanTra() { return hanTra.get(); }
    public void setHanTra(String hanTra) { this.hanTra.set(hanTra); }

    public int getSoNgayQuaHan() { return soNgayQuaHan.get(); }
    public void setSoNgayQuaHan(int soNgayQuaHan) { this.soNgayQuaHan.set(soNgayQuaHan); }

    // Property methods
    public StringProperty getMaSoProperty() { return maSo; }
    public StringProperty getHoTenProperty() { return hoTen; }
    public StringProperty getMaTaiLieuProperty() { return maTaiLieu; }
    public StringProperty getMaBanSaoProperty() { return maBanSao; }
    public StringProperty getHanTraProperty() { return hanTra; }
    public IntegerProperty getSoNgayQuaHanProperty() { return soNgayQuaHan; }
}
