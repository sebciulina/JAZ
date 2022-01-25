package com.example.workshop.controlers;

import com.example.workshop.FormData.CreateCarFormData;
import com.example.workshop.FormData.CreateCustomerFromData;
import com.example.workshop.entities.Cars;
import com.example.workshop.entities.Customers;
import com.example.workshop.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("customers")
@RequiredArgsConstructor
public class CustomersController {
    final CustomerService customerService;

    @GetMapping
    public String getCustomers(Model model){
        model.addAttribute("customer", customerService.findAllCustomers());
        return "customers";
    }

    @GetMapping("/{id}")
    public String getCustomer(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.getCustomer(id));
        return "customers";
    }

    @GetMapping("/create")
    public String showCreateCustomerForm(Model model){
        model.addAttribute("formCustomer", new CreateCustomerFromData());
        return "customersCreate";
    }
    @PostMapping("/create")
    public String saveCustomer(@Valid @ModelAttribute("formCustomer") CreateCustomerFromData formCustomer, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "customersCreate";
        }

        customerService.createCustomer(formCustomer.toParameters());
        return "redirect:/customers";
    }

    @GetMapping("/search")
    public String findCustomers(@RequestParam(value = "fname", required = false) String fname, @RequestParam(value = "lname", required = false) String lname, @RequestParam(value = "email",required = false) String email ,Model model){
        List<Customers> customersList = customerService.searchCustomers(fname,lname,email);
        model.addAttribute("customer", customersList);
        return "customersSearch";
    }

    @GetMapping("/update")
    public String showUpdateCustomer(Model model){
        model.addAttribute("formCustomer", new CreateCustomerFromData());
        return "customersUpdate";
    }
    @PostMapping("/update")
    public String updateCustomer(@ModelAttribute("formCustomer") CreateCustomerFromData formCustomer,BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "customerUpdate";
        }
        customerService.updateCustomer(formCustomer.getFname(),formCustomer.getLname(),formCustomer.getEmail(),formCustomer.getPhonenumber(),formCustomer.getPreferredContact(),formCustomer.getId());
        return "redirect:/customers";
    }

    @GetMapping("/delete")
    public String showDeleteCustomer(Model model){
        model.addAttribute("formCustomer", new CreateCustomerFromData());
        return "customersDelete";
    }
    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("formCustomer") CreateCustomerFromData formCustomer,BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "customersDelete";
        }
        customerService.deleteCustomer(formCustomer.getId());
        return "redirect:/customers";
    }
}
