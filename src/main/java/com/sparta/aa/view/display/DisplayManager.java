package com.sparta.aa.view.display;

import com.sparta.aa.model.sort.Sorter;

public class DisplayManager {


    public static void printSortingReport(Sorter sorterUsed, int[] unsorted, int[] sorted, long performanceTime) {
        System.out.println(getChosenSorter(sorterUsed));
        printSortedArrayComparison(unsorted, sorted);
        System.out.println(getPerformanceTime(performanceTime));
    }

    private static String getPerformanceTime(long performanceTime) {
        return "Performance time(ns): " + performanceTime;
    }

    private static void printSortedArrayComparison(int[] unsorted, int[] sorted) {
        System.out.println(
            "Unsorted\t|\tSorted"
        );
        for (int i = 0; i < unsorted.length; i++) {
            System.out.println(
                unsorted[i] + "\t\t\t|\t" + sorted[i]
            );
        }
    }

    private static String getChosenSorter(Sorter sorterUsed) {
        return "Sorter chosen: " + sorterUsed.getName();
    }

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
