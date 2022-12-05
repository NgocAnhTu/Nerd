package com.example.model;

public class Notifications {
    private String Notifications;
    private int img;

    public Notifications(int img) {
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Notifications(String notifications) {
        Notifications = notifications;
    }

    public String getNotifications() {
        return Notifications;
    }

    public void setNotifications(String notifications) {
        Notifications = notifications;
    }
}
