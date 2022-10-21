package com.sparta.aa.controller;

import com.sparta.aa.controller.sort.BubbleSort;
import com.sparta.aa.controller.sort.MergeSort;
import com.sparta.aa.model.sort.ArrayGenerator;
import com.sparta.aa.model.sort.Sorters;

import java.util.*;

public class SortManager {

    public static void start() {
        String sorterChoice;
        Scanner scan = new Scanner(System.in);

        do {
            printSorterMenu();
            sorterChoice = scan.nextLine();
            Sorters sorter = null;

            try {
                sorter = Sorters.values()[Integer.parseInt(sorterChoice)];
            } catch (NumberFormatException e) {
                System.out.println("Could not find a valid sorting choice\n"); // FINE
            }

            if (sorter != null) {
                switch (sorter) {
                    case BUBBLE -> System.out.println(Arrays.toString(new BubbleSort().sort(generateRandomArray())));
                    case MERGE -> System.out.println(Arrays.toString(new MergeSort().sort(generateRandomArray())));
                    default -> System.out.println("Invalid sorter selection\n"); // INFO
                }
            }
        } while (!sorterChoice.equalsIgnoreCase("Q"));
    }

    public static int[] generateRandomArray() {
        int arraySizeChoice = 0;
        Scanner scan = new Scanner(System.in);

        do {
            printArraySizePrompt();
            try {
                arraySizeChoice = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input value is not a valid number"); // INFO
            }
            scan.nextLine(); // Handles one number per line and resets input mismatch exception
        } while (arraySizeChoice < 1 ||  arraySizeChoice > 1000);

        return ArrayGenerator.generate(arraySizeChoice);
    }

    static void printSorterMenu() {
        System.out.println("Enter the number of the sorter you wish to use or (Q)uit:\n");
        System.out.println(
                "\t" + Sorters.valueOf("BUBBLE").ordinal() + ".\t" + Sorters.BUBBLE.getName() + "\n" +
                "\t" + Sorters.valueOf("MERGE").ordinal() + ".\t" + Sorters.MERGE.getName() + "\n"
        );
    }

    static void printArraySizePrompt() {
        System.out.println("Enter the size of the random array to sort (1 - 1000):");
    }
}
