package com.sparta.aa.model.sort;

public enum Sorter {
    BUBBLE("Bubblesort"), MERGE("Mergesort");

    private final String name;

    Sorter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
