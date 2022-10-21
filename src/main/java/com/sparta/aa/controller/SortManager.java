package com.sparta.aa.controller;

import com.sparta.aa.controller.sort.BubbleSort;
import com.sparta.aa.controller.sort.MergeSort;
import com.sparta.aa.model.ArrayGenerator;
import com.sparta.aa.model.sort.Sorter;
import com.sparta.aa.view.display.DisplayManager;

import java.util.*;

public class SortManager {

    static final int MINARRAYSIZE = 1;
    static final int MAXARRAYSIZE = 1000;
    static final int MINARRAYVALUERANGE = -100;
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

            if (sorter != null) {
                switch (sorter) {
                    case BUBBLE -> System.out.println(Arrays.toString(new BubbleSort().sort(promptRandomArray())));
                    case MERGE -> System.out.println(Arrays.toString(new MergeSort().sort(promptRandomArray())));
                    default -> System.out.println("This option is unavailable\n"); // INFO
                }
            }
        } while (!sorterChoice.equalsIgnoreCase("Q"));
    }

    public static int[] promptRandomArray() {
        int arraySizeChoice = 0;
        int[] randomIntArray = null;
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

        // TODO catch exception thrown by ArrayGenerator
        try {
            randomIntArray = ArrayGenerator.generateRandomIntArray(arraySizeChoice, MINARRAYVALUERANGE, MAXARRAYVALUERANGE);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return randomIntArray;
    }

}
