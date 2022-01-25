package com.example.workshop.services;

import com.example.workshop.CreationParameters.CarCreationParameters;
import com.example.workshop.entities.Cars;
import com.example.workshop.repos.CarsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class CarService {
    private final CarsRepository carsRepository;

    public CarService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    public List<Cars> findAllCars() {
        return carsRepository.findAll();
    }

    public Cars getCar(int id) {
        return carsRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Cars createCar(CarCreationParameters parameters) {
        Cars cars = new Cars(parameters.getId(),parameters.getCustomerId(),parameters.getEmployeeId(),parameters.getModel(),parameters.getStatus(),parameters.getTotalCost());
        return carsRepository.save(cars);
    }


    public void deleteCar(int id) {
        carsRepository.deleteById(id);
    }

    public List<Cars> searchCars(String model, String status){
        return carsRepository.findCarsBy(model, status);
    }
    @Transactional
    public void updateCar(int customerId, int employeeId, String model, String status,double totalCost, int id){
        carsRepository.setCarInfoById(customerId,employeeId,model,status,totalCost,id);
    }
}
