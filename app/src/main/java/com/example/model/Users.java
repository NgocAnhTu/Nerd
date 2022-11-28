package com.example.model;

public class Users {
    private Integer ID;
    private String Username;
    private String Password;
    private String Fullname;
    private Integer Phone;
    private String Email;
    private Integer Birth;
    private byte[] Photo;   /////

    public Users(Integer ID, String username, String password, String fullname, Integer phone, String email, Integer birth, byte[] photo) {
        this.ID = ID;
        this.Username = username;
        this.Password = password;
        this.Fullname = fullname;
        this.Phone = phone;
        this.Email = email;
        this.Birth = birth;
        this.Photo = photo;
    }
    public Users(){}

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public  String getUsername() { return Username; }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public Integer getPhone() {
        return Phone;
    }

    public void setPhone(Integer phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getBirth() {
        return Birth;
    }

    public void setBirth(Integer birth) {
        Birth = birth;
    }

    public byte[] getPhoto() {
        return Photo;
    }

    public void setPhoto(byte[] photo) {
        Photo = photo;
    }
}
