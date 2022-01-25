package com.example.workshop.FormData;

import com.example.workshop.CreationParameters.CustomerCreationParameters;

import javax.validation.constraints.NotNull;

public class CreateCustomerFromData {
    @NotNull
    private int id;
    @NotNull
    private String fname;
    @NotNull
    private String lname;
    @NotNull
    private String email;
    @NotNull
    private String phonenumber;
    @NotNull
    private String preferredContact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPreferredContact() {
        return preferredContact;
    }

    public void setPreferredContact(String preferredContact) {
        this.preferredContact = preferredContact;
    }

    public CustomerCreationParameters toParameters(){
        return new CustomerCreationParameters(id,fname,lname,email,phonenumber,preferredContact);
    }
}
