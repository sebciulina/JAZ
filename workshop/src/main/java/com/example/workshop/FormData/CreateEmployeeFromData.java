package com.example.workshop.FormData;

import com.example.workshop.CreationParameters.EmployeesCreationParameters;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class CreateEmployeeFromData {
    @NotNull
    private int id;
    @NotNull
    private String fname;
    @NotNull
    private String lname;
    @NotNull
    private String phonenumber;
    @NotNull
    private int departmentId;
    @NotNull
    private double salary;
    @NotNull
    private Timestamp hireDate;

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

    public EmployeesCreationParameters toParameters(){
        return new EmployeesCreationParameters(id,fname,lname,phonenumber,departmentId,salary,hireDate);
    }
}
