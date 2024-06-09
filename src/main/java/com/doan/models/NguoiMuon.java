package com.doan.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.DoubleProperty;
public class NguoiMuon {
    private StringProperty maSo;
    private StringProperty hoTen;
    private StringProperty sdt;
    private StringProperty ngheNghiep;
    private DoubleProperty tongTienPhat;
    private StringProperty danhSachPhat;

    // Constructor, getters, setters, property methods
    public NguoiMuon() {
        this.maSo = new SimpleStringProperty();
        this.hoTen = new SimpleStringProperty();
        this.sdt = new SimpleStringProperty();
        this.ngheNghiep = new SimpleStringProperty();
        this.tongTienPhat = new SimpleDoubleProperty();
        this.danhSachPhat = new SimpleStringProperty();
    }

    // Getters & Setters
    public String getMaSo() { return maSo.get(); }
    public void setMaSo(String maSo) { this.maSo.set(maSo); }

    public String getHoTen() { return hoTen.get(); }
    public void setHoTen(String hoTen) { this.hoTen.set(hoTen); }

    public String getSdt() { return sdt.get(); }
    public void setSdt(String sdt) { this.sdt.set(sdt); }

    public String getNgheNghiep() { return ngheNghiep.get(); }
    public void setNgheNghiep(String ngheNghiep) { this.ngheNghiep.set(ngheNghiep); }

    public double getTongTienPhat() { return tongTienPhat.get(); }
    public void setTongTienPhat(double tongTienPhat) { this.tongTienPhat.set(tongTienPhat); }

    public String getDanhSachPhat() { return danhSachPhat.get(); }
    public void setDanhSachPhat(String danhSachPhat) { this.danhSachPhat.set(danhSachPhat); }

    // Property methods
    public StringProperty getMaSoProperty() { return maSo; }
    public StringProperty getHoTenProperty() { return hoTen; }
    public StringProperty getSdtProperty() { return sdt; }
    public StringProperty getNgheNghiepProperty() { return ngheNghiep; }

    public DoubleProperty getTongTienPhatProperty() { return tongTienPhat; }
    public StringProperty getDanhSachPhatProperty() { return danhSachPhat; }
}
