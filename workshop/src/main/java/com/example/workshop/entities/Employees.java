package com.example.workshop.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Employees {
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
    @Column(name = "phonenumber")
    private String phonenumber;
    @Basic
    @Column(name = "department_id")
    private int departmentId;
    @Basic
    @Column(name = "salary")
    private double salary;
    @Basic
    @Column(name = "hire_date")
    private Timestamp hireDate;


    protected Employees(){

    }

    public Employees(int id, String fname, String lname, String phonenumber, int departmentId, double salary, Timestamp hireDate) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.phonenumber = phonenumber;
        this.departmentId = departmentId;
        this.salary = salary;
        this.hireDate = hireDate;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Timestamp getHireDate() {
        return hireDate;
    }

    public void setHireDate(Timestamp hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return id == employees.id && departmentId == employees.departmentId && Double.compare(employees.salary, salary) == 0 && Objects.equals(fname, employees.fname) && Objects.equals(lname, employees.lname) && Objects.equals(phonenumber, employees.phonenumber) && Objects.equals(hireDate, employees.hireDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fname, lname, phonenumber, departmentId, salary, hireDate);
    }
}
