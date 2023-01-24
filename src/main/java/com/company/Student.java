package com.company;

public class Student {
    private int id;
    private String username;
    private String eMail;
    private String address;
    private SchoolData data;










    public Student(int id, String username, String eMail, String address, SchoolData data) {
        this.id = id;
        this.username = username;
        this.eMail = eMail;
        this.address = address;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SchoolData getData() {
        return data;
    }

    public void setData(SchoolData data) {
        this.data = data;
    }
}
