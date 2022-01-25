package com.example.workshop.controlers;

import com.example.workshop.FormData.CreateCarFormData;
import com.example.workshop.entities.Cars;
import com.example.workshop.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("cars")
@RequiredArgsConstructor
public class CarsController {
    final CarService carsService;

    @GetMapping("/create")
    public String showCreateCarForm(Model model){
        model.addAttribute("formCar", new CreateCarFormData());
        return "carsCreate";
    }
    @PostMapping("/create")
    public String saveCar(@Valid @ModelAttribute("formCar") CreateCarFormData formCar, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
           return "carsCreate";
        }

        carsService.createCar(formCar.toPararameters());
        return "redirect:/cars";
    }
    @GetMapping()
    public String getCars(Model model){
        model.addAttribute("car", carsService.findAllCars());
        return "cars";
    }

    @GetMapping("/{id}")
    public String getCar(@PathVariable int id, Model model){
        model.addAttribute("car", carsService.getCar(id));
        return "cars";
    }

    @GetMapping("/search")
    public String findCars(@RequestParam(value = "model", required = false) String models, @RequestParam(value = "status", required = false) String status, Model model){
        List<Cars> carsList = carsService.searchCars(models,status);
        model.addAttribute("car", carsList);
        return "carsSearch";
    }

    @GetMapping("/update")
    public String showUpdateCar(Model model){
        model.addAttribute("formCar", new CreateCarFormData());
        return "carsUpdate";
    }
    @PostMapping("/update")
    public String updateCar(@ModelAttribute("formCar") CreateCarFormData formCar,BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "carsUpdate";
        }
        carsService.updateCar(formCar.getCustomerId(),formCar.getEmployeeId(),formCar.getModel(),formCar.getStatus(),formCar.getTotalCost(),formCar.getId());
        return "redirect:/cars";
    }

    @GetMapping("/delete")
    public String showDeleteCar(Model model){
        model.addAttribute("formCar", new CreateCarFormData());
        return "carsDelete";
    }
    @PostMapping("/delete")
    public String deleteCar(@ModelAttribute("formCar") CreateCarFormData formCar,BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "carsDelete";
        }
        carsService.deleteCar(formCar.getId());
        return "redirect:/cars";
    }
}
