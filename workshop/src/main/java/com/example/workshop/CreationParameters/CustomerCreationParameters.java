package com.example.workshop.CreationParameters;

import lombok.Getter;

@Getter
public class CustomerCreationParameters {
    private final int id;
    private final String fname;
    private final String lname;
    private final String email;
    private final String phonenumber;
    private final String preferredContact;

    public CustomerCreationParameters(int id, String fname, String lname, String email, String phonenumber, String preferredContact) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.preferredContact = preferredContact;
    }
}
