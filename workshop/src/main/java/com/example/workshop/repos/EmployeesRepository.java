package com.example.workshop.repos;


import com.example.workshop.entities.Customers;
import com.example.workshop.entities.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;


public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
    @Query("SELECT t from Employees t where t.fname like %?1% and t.lname like %?2%")
    List<Employees> findEmployeesBy(String fname, String lname);

    @Modifying
    @Query("update Employees u set u.fname = ?1, u.lname = ?2, u.phonenumber = ?3, u.departmentId = ?4, u.salary = ?5,u.hireDate = ?6 where u.id = ?7")
    void setEmployeeInfoById(String fname, String lname, String phonenumber, int deparmentId, Double salary, Timestamp hireDate, int id);
}
