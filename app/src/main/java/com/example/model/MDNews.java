package com.example.model;

import java.io.Serializable;

public class MDNews implements Serializable {
    int detailThump;
    String detailTittle;
    String detailDate_Name;
    String detailContent;

    public int getDetailThump() {
        return detailThump;
    }

    public void setDetailThump(int detailThump) {
        this.detailThump = detailThump;
    }

    public String getDetailTittle() {
        return detailTittle;
    }

    public void setDetailTittle(String detailTittle) {
        this.detailTittle = detailTittle;
    }

    public String getDetailDate_Name() {
        return detailDate_Name;
    }

    public void setDetailDate_Name(String detailDate_Name) {
        this.detailDate_Name = detailDate_Name;
    }

    public String getDetailContent() {
        return detailContent;
    }

    public void setDetailContent(String detailContent) {
        this.detailContent = detailContent;
    }

    public MDNews(int detailThump, String detailTittle, String detailDate_Name, String detailContent) {
        this.detailThump = detailThump;
        this.detailTittle = detailTittle;
        this.detailDate_Name = detailDate_Name;
        this.detailContent = detailContent;
    }
}
