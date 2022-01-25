package com.example.workshop.repos;


import com.example.workshop.entities.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CustomersRepository extends JpaRepository<Customers, Integer> {

    @Query("SELECT t from Customers t where t.fname like %?1% and t.lname like %?2% and t.email like %?3%")
    List<Customers> findCustomersBy(String fname, String lname,String email);

    @Modifying
    @Query("update Customers u set u.fname = ?1, u.lname = ?2, u.email = ?3, u.phonenumber = ?4, u.preferredContact = ?5 where u.id = ?6")
    void setCustomerInfoById(String fname, String lname, String email, String phonenumber, String prefferedContact, int id);
}
