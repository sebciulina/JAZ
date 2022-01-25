package com.example.workshop.CreationParameters;

import lombok.Getter;

@Getter
public class DepartmentsCreationParameters {
    private final int id;
    private final String name;

    public DepartmentsCreationParameters(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
