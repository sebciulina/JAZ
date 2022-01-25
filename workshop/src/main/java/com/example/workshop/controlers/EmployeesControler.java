package com.example.workshop.controlers;

import com.example.workshop.FormData.CreateCustomerFromData;
import com.example.workshop.FormData.CreateEmployeeFromData;
import com.example.workshop.entities.Customers;
import com.example.workshop.entities.Employees;
import com.example.workshop.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("employees")
@RequiredArgsConstructor
public class EmployeesControler {
    final EmployeeService employeeService;

    @GetMapping()
    public String getEmployees(Model model){
        model.addAttribute("employee", employeeService.findAllEmployees());
        return "employees";
    }

    @GetMapping("/{id}")
    public String getEmployee(@PathVariable int id, Model model){
        model.addAttribute("employee", employeeService.getEmployee(id));
        return "employees";
    }

    @GetMapping("/create")
    public String showCreateEmployeeForm(Model model){
        model.addAttribute("formEmployee", new CreateEmployeeFromData());
        return "employeesCreate";
    }
    @PostMapping("/create")
    public String saveEmployee(@Valid @ModelAttribute("formEmployee") CreateEmployeeFromData formEmployee, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "employeesCreate";
        }

        employeeService.createEmployee(formEmployee.toParameters());
        return "redirect:/employees";
    }

    @GetMapping("/search")
    public String findEmployee(@RequestParam(value = "fname", required = false) String fname, @RequestParam(value = "lname", required = false) String lname ,Model model){
        List<Employees> employeesList = employeeService.searchEmployees(fname,lname);
        model.addAttribute("employee", employeesList);
        return "employeesSearch";
    }

    @GetMapping("/update")
    public String showUpdateEmployee(Model model){
        model.addAttribute("formEmployee", new CreateEmployeeFromData());
        return "employeesUpdate";
    }
    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("formEmployee") CreateEmployeeFromData formEmployee,BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "employeesUpdate";
        }
        employeeService.updateEmployee(formEmployee.getFname(),formEmployee.getLname(),formEmployee.getPhonenumber(),formEmployee.getDepartmentId(),formEmployee.getSalary(),formEmployee.getHireDate(),formEmployee.getId());
        return "redirect:/employees";
    }

    @GetMapping("/delete")
    public String showDeleteEmployee(Model model){
        model.addAttribute("formEmployee", new CreateEmployeeFromData());
        return "employeesDelete";
    }
    @PostMapping("/delete")
    public String deleteEmployee(@ModelAttribute("formEmployee") CreateEmployeeFromData formEmployee,BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "employeesDelete";
        }
       employeeService.deleteEmployee(formEmployee.getId());
        return "redirect:/employees";
    }
}
