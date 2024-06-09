package com.doan.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BanSao {
    private StringProperty maTaiLieu;
    private StringProperty maBanSao;
    private StringProperty trangThai;
    private StringProperty soPhong;
    private StringProperty soKe;
    private StringProperty soNgan;

    // Constructor
    public BanSao() {
        this.maTaiLieu = new SimpleStringProperty();
        this.maBanSao = new SimpleStringProperty();
        this.trangThai = new SimpleStringProperty();
        this.soPhong = new SimpleStringProperty();
        this.soKe = new SimpleStringProperty();
        this.soNgan = new SimpleStringProperty();
    }

    // Getters & Setters
    public String getMaTaiLieu() { return maTaiLieu.get(); }
    public void setMaTaiLieu(String maTaiLieu) { this.maTaiLieu.set(maTaiLieu); }
    public String getMaBanSao() { return maBanSao.get(); }
    public void setMaBanSao(String maBanSao) { this.maBanSao.set(maBanSao); }
    public String getTrangThai() { return trangThai.get(); }
    public void setTrangThai(String trangThai) { this.trangThai.set(trangThai); }
    public String getSoPhong() { return soPhong.get(); }
    public void setSoPhong(String soPhong) { this.soPhong.set(soPhong); }
    public String getSoKe() { return soKe.get(); }
    public void setSoKe(String soKe) { this.soKe.set(soKe); }
    public String getSoNgan() { return soNgan.get(); }
    public void setSoNgan(String soNgan) { this.soNgan.set(soNgan); }

    // Property methods
    public StringProperty getMaTaiLieuProperty() { return maTaiLieu; }
    public StringProperty getMaBanSaoProperty() { return maBanSao; }
    public StringProperty getTrangThaiProperty() { return trangThai; }
    public StringProperty getSoPhongProperty() { return soPhong; }
    public StringProperty getSoKeProperty() { return soKe; }
    public StringProperty getSoNganProperty() { return soNgan; }
}
