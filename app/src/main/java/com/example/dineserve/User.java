package com.example.dineserve;

public class User {

    private int Id;
    private String Phonenumber;
    private String Pannumber;
    private String AdhaarNumber;
    private String name;
    private String email;
    private String password;
    private String Address;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }


    public String getPannumber() {
        return Pannumber;
    }

    public void setPannumber(String pannumber) {
        Pannumber = pannumber;
    }

    public String getAdhaarNumber() {
        return AdhaarNumber;
    }

    public void setAdhaarNumber(String adhaarNumber) {
        AdhaarNumber = adhaarNumber;
    }




    public String getPhonenumber() {
        return Phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        Phonenumber = phonenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }


}
