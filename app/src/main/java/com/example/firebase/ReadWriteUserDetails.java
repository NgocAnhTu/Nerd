package com.example.firebase;

public class ReadWriteUserDetails {
    public String name, doB, phone;

    public ReadWriteUserDetails(){};

    public ReadWriteUserDetails(String textName, String textDOB, String textPhone) {
        this.name = textName;
        this.doB = textDOB;
        this.phone = textPhone;
    }
}
