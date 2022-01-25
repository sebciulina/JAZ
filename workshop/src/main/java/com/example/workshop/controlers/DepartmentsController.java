package com.example.workshop.controlers;

import com.example.workshop.entities.Departments;
import com.example.workshop.services.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("departments")
@RequiredArgsConstructor
public class DepartmentsController {
    final DepartmentService departmentService;

    @GetMapping()
    public String getDepartments(Model model){
        model.addAttribute("department", departmentService.findAllDepartments());
        return "departments";
    }

    @GetMapping("/{id}")
    public String getDepartment(@PathVariable int id, Model model){
        model.addAttribute("department", departmentService.getDepartment(id));
        return "departments";
    }
}
