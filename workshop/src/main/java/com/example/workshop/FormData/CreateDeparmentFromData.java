package com.example.workshop.FormData;

import com.example.workshop.CreationParameters.DepartmentsCreationParameters;

import javax.validation.constraints.NotNull;

public class CreateDeparmentFromData {
    @NotNull
    private int id;
    @NotNull
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentsCreationParameters toParameters(){
        return new DepartmentsCreationParameters(id,name);
    }
}
