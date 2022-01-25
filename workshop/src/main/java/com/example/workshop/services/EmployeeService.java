package com.example.workshop.services;



import com.example.workshop.CreationParameters.EmployeesCreationParameters;
import com.example.workshop.entities.Customers;
import com.example.workshop.entities.Employees;
import com.example.workshop.repos.EmployeesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

@Service
public class EmployeeService {
    private final EmployeesRepository employeesRepository;

    public EmployeeService(EmployeesRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    public List<Employees> findAllEmployees() {
        return employeesRepository.findAll();
    }

    public Employees getEmployee(int id) {
        return employeesRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Employees createEmployee(EmployeesCreationParameters parameters) {
        Employees employee = new Employees(parameters.getId(),parameters.getFname(),parameters.getLname(),parameters.getPhonenumber(),parameters.getDepartmentId(),parameters.getSalary(),parameters.getHireDate());
        return employeesRepository.save(employee);
    }

    public List<Employees> searchEmployees(String fName, String lName){
        return employeesRepository.findEmployeesBy(fName, lName);
    }

    @Transactional
    public void updateEmployee(String fname, String lname, String phoneNumber, int departmentId, Double salary, Timestamp hiredate, int id){
        employeesRepository.setEmployeeInfoById(fname,lname,phoneNumber,departmentId,salary,hiredate,id);
    }

    public void deleteEmployee(int id) {
        employeesRepository.deleteById(id);
    }
}
