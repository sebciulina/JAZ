package com.example.workshop.services;

import com.example.workshop.CreationParameters.CustomerCreationParameters;
import com.example.workshop.entities.Cars;
import com.example.workshop.entities.Customers;
import com.example.workshop.repos.CustomersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerService {
    private final CustomersRepository customersRepository;

    public CustomerService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public List<Customers> findAllCustomers() {
        return customersRepository.findAll();
    }

    public Customers getCustomer(int id) {
        return customersRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Customers createCustomer(CustomerCreationParameters parameters) {
        Customers customers = new Customers(parameters.getId(),parameters.getFname(),parameters.getLname(),parameters.getEmail(),parameters.getPhonenumber(),parameters.getPreferredContact());
        return customersRepository.save(customers);
    }

    public List<Customers> searchCustomers(String fName, String lName, String email){
        return customersRepository.findCustomersBy(fName, lName, email);
    }

    @Transactional
    public void updateCustomer(String fname, String lname, String email,String phoneNumber, String prefferedContact, int id){
        customersRepository.setCustomerInfoById(fname,lname,email,phoneNumber,prefferedContact,id);
    }

    public void deleteCustomer(int id) {
        customersRepository.deleteById(id);
    }
}
