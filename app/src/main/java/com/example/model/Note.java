package com.example.model;

public class Note {
    private int id;
    private String tenCV;

    public Note(int id, String tenCV) {
        this.id = id;
        this.tenCV = tenCV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenCV() {
        return tenCV;
    }

    public void setTenCV(String tenCV) {
        this.tenCV = tenCV;
    }
}