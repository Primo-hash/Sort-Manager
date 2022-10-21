package com.sparta.aa.model.sort;

public enum Sorters {
    BUBBLE("Bubblesort"), MERGE("Mergesort");

    private final String name;

    Sorters(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
