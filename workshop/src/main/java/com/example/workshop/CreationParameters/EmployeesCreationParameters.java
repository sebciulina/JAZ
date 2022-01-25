package com.example.workshop.CreationParameters;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class EmployeesCreationParameters {
    private final int id;
    private final String fname;
    private final String lname;
    private final String phonenumber;
    private final int departmentId;
    private final double salary;
    private final Timestamp hireDate;

    public EmployeesCreationParameters(int id, String fname, String lname, String phonenumber, int departmentId, double salary, Timestamp hireDate) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.phonenumber = phonenumber;
        this.departmentId = departmentId;
        this.salary = salary;
        this.hireDate = hireDate;
    }
}
