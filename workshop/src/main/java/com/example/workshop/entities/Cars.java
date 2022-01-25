package com.example.workshop.entities;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Objects;

@Entity
public class Cars {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "customer_id")
    private int customerId;
    @Basic
    @Column(name = "employee_id")
    private int employeeId;
    @Basic
    @Column(name = "model")
    private String model;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "total_cost")
    private double totalCost;

    protected Cars(){

    }

    public Cars(int id, int customerId, int employeeId, String model, String status, double totalCost) {
        this.id = id;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.model = model;
        this.status = status;
        this.totalCost = totalCost;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return id == cars.id && customerId == cars.customerId && employeeId == cars.employeeId && Double.compare(cars.totalCost, totalCost) == 0 && Objects.equals(model, cars.model) && Objects.equals(status, cars.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, employeeId, model, status, totalCost);
    }
}
