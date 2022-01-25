package com.example.workshop.repos;


import com.example.workshop.entities.Departments;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DepartmentsRepository extends JpaRepository<Departments, Integer> {
}
