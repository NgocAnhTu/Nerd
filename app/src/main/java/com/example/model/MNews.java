package com.example.model;

public class MNews {
    int Thump;
    String Tittle;
    String View;

    public int getThump() {
        return Thump;
    }

    public void setThump(int thump) {
        Thump = thump;
    }

    public String getTittle() {
        return Tittle;
    }

    public void setTittle(String tittle) {
        Tittle = tittle;
    }

    public String getView() {
        return View;
    }

    public void setView(String view) {
        View = view;
    }

    public MNews(int thump, String tittle, String view) {
        Thump = thump;
        Tittle = tittle;
        View = view;
    }
}
