package com.example.workshop.FormData;

import com.example.workshop.CreationParameters.CarCreationParameters;

import javax.validation.constraints.NotNull;

public class CreateCarFormData {
    @NotNull
    private int id;
    @NotNull
    private int customerId;
    @NotNull
    private int employeeId;
    @NotNull
    private String model;
    @NotNull
    private String status;
    @NotNull
    private double totalCost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public CarCreationParameters toPararameters(){
        return new CarCreationParameters(id,customerId,employeeId,model,status,totalCost);
    }
}
