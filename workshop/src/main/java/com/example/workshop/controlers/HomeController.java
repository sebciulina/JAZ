package com.example.workshop.controlers;

import com.example.workshop.entities.Customers;
import com.example.workshop.entities.Departments;
import com.example.workshop.entities.Employees;
import com.example.workshop.services.CustomerService;
import com.example.workshop.services.DepartmentService;
import com.example.workshop.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class HomeController {

    @GetMapping()
    public String getString(Model model) {
        return "home";
    }

}
