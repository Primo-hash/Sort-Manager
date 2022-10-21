package com.sparta.aa.view.display;

import com.sparta.aa.model.sort.Sorter;

public class DisplayManager {

    public static void printSorterMenu(Sorter[] sorters) {
        System.out.println("Enter the number of the sorter you wish to use or (Q)uit:");
        for (Sorter sorter: sorters) {
            System.out.println("\t" + sorter.ordinal() + ".\t" + sorter.getName());
        }
    }

    public static void printArraySizePrompt() {
        System.out.println("Enter the size of the random array to sort (1 - 1000):");
    }
}
