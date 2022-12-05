package com.example.model;

public class Lophocsapdienra {
    String tenbaihoc, gio, ngay, nameGV, soLuonghv;

    public Lophocsapdienra(String tenbaihoc, String gio, String ngay, String nameGV, String soLuonghv) {
        this.tenbaihoc = tenbaihoc;
        this.gio = gio;
        this.ngay = ngay;
        this.nameGV = nameGV;
        this.soLuonghv = soLuonghv;
    }

    public String getTenbaihoc() {
        return tenbaihoc;
    }

    public void setTenbaihoc(String tenbaihoc) {
        this.tenbaihoc = tenbaihoc;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getNameGV() {
        return nameGV;
    }

    public void setNameGV(String nameGV) {
        this.nameGV = nameGV;
    }

    public String getSoLuonghv() {
        return soLuonghv;
    }

    public void setSoLuonghv(String soLuonghv) {
        this.soLuonghv = soLuonghv;
    }
}
