package com.example.workshop.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Customers {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "fname")
    private String fname;
    @Basic
    @Column(name = "lname")
    private String lname;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phonenumber")
    private String phonenumber;
    @Basic
    @Column(name = "preferred_contact")
    private String preferredContact;

    protected Customers(){

    }

    public Customers(int id, String fname, String lname, String email, String phonenumber, String preferredContact) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.preferredContact = preferredContact;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return id == customers.id && Objects.equals(fname, customers.fname) && Objects.equals(lname, customers.lname) && Objects.equals(email, customers.email) && Objects.equals(phonenumber, customers.phonenumber) && Objects.equals(preferredContact, customers.preferredContact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fname, lname, email, phonenumber, preferredContact);
    }
}
