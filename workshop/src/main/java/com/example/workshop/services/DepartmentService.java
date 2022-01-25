package com.example.workshop.services;



import com.example.workshop.entities.Departments;
import com.example.workshop.repos.DepartmentsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentsRepository departmentsRepository;

    public DepartmentService(DepartmentsRepository departmentsRepository) {
        this.departmentsRepository = departmentsRepository;
    }

    public List<Departments> findAllDepartments() {
        return departmentsRepository.findAll();
    }

    public Departments getDepartment(int id) {
        return departmentsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Departments createDepartment(Departments department) {
        return departmentsRepository.save(department);
    }

    public void updateDepartment(int id, Departments department) {
        final Departments existingDepartment = departmentsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        departmentsRepository.save(department);
    }

    public void deleteDepartment(int id) {
        departmentsRepository.deleteById(id);
    }
}
