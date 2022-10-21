package com.sparta.aa.controller;

import com.sparta.aa.model.ArrayGenerator;
import com.sparta.aa.model.exception.SorterLoaderException;
import com.sparta.aa.model.factory.SortFactory;
import com.sparta.aa.model.sort.Sorter;
import com.sparta.aa.view.display.DisplayManager;

import java.util.*;

public class SortManager {

    static final int MINARRAYSIZE = 1;
    static final int MAXARRAYSIZE = 1000;
    static final int MINARRAYVALUERANGE = 0;
    static final int MAXARRAYVALUERANGE = 1000;

    public static void start() {
        String sorterChoice;
        Scanner scan = new Scanner(System.in);

        do {
            DisplayManager.printSorterMenu(Sorter.values());
            sorterChoice = scan.nextLine();
            Sorter sorter = null;

            try {
                sorter = Sorter.values()[Integer.parseInt(sorterChoice)];
            } catch (NumberFormatException e) {
                System.out.println("Could not find a valid sorting choice\n"); // FINE
            }

            selectSorter(sorter);
        } while (!sorterChoice.equalsIgnoreCase("Q"));
    }

    private static void selectSorter(Sorter sorter) {
        if (sorter != null) {
            int[] unsorted = promptRandomArray();
            try {
                switch (sorter) {
                    case BUBBLE:
                        DisplayManager.printSortingReport(
                                Sorter.BUBBLE,
                                unsorted,
                                SortFactory.generateSorter(Sorter.BUBBLE).sort(unsorted),
                                0
                        );
                        break;
                    case MERGE:
                        DisplayManager.printSortingReport(
                                Sorter.MERGE,
                                unsorted,
                                SortFactory.generateSorter(Sorter.MERGE).sort(unsorted),
                                0
                        );
                    case BST:
                        DisplayManager.printSortingReport(
                                Sorter.BST,
                                unsorted,
                                SortFactory.generateSorter(Sorter.BST).sort(unsorted),
                                0
                        );
                    default:
                        System.out.println("This sorting option is unavailable\n"); // INFO
                }
            } catch (SorterLoaderException e) {
                System.out.println(e.getMessage()); // INFO
            }
        }
    }

    public static int[] promptRandomArray() {
        int arraySizeChoice = getArraySizeChoice();;
        int[] randomIntArray = null;
        // TODO catch custom exception thrown by ArrayGenerator
        try {
            randomIntArray = ArrayGenerator.generateRandomIntArray(arraySizeChoice, MINARRAYVALUERANGE, MAXARRAYVALUERANGE);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return randomIntArray;
    }

    private static int getArraySizeChoice() {
        int arraySizeChoice = 0;
        Scanner scan = new Scanner(System.in);

        do {
            DisplayManager.printArraySizePrompt();
            try {
                arraySizeChoice = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input value is not a valid number"); // INFO
            }
            scan.nextLine(); // Handles one number per line and resets input mismatch exception
        } while (arraySizeChoice < MINARRAYSIZE ||  arraySizeChoice > MAXARRAYSIZE);
        return arraySizeChoice;
    }

}
