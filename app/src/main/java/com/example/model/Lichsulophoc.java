package com.example.model;

public class Lichsulophoc {
    String tenbaihoc, gio, ngay, nameGV;

    public Lichsulophoc(String tenbaihoc, String gio, String ngay, String nameGV) {
        this.tenbaihoc = tenbaihoc;
        this.gio = gio;
        this.ngay = ngay;
        this.nameGV = nameGV;
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
}
