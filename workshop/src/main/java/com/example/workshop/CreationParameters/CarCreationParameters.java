package com.example.workshop.CreationParameters;

import lombok.Getter;

@Getter
public class CarCreationParameters {
    private final int id;
    private final int customerId;
    private final int employeeId;
    private final String model;
    private final String status;
    private final double totalCost;

    public CarCreationParameters(int id, int customerId, int employeeId, String model, String status, double totalCost) {
        this.id = id;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.model = model;
        this.status = status;
        this.totalCost = totalCost;
    }
}
