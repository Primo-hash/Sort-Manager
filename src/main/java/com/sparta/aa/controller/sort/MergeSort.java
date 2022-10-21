package com.sparta.aa.controller.sort;

import java.util.Arrays;

public class MergeSort implements Sortable {

    public int[] sort(int[] unsorted) {
        int[] sortCandidate = Arrays.copyOf(unsorted, unsorted.length);     // Copy of unsorted numbers
        int leftBound = 0;
        int rightBound = sortCandidate.length - 1;

        sortRecursive(sortCandidate, leftBound, rightBound);

        return sortCandidate;
    }

    public static void sortRecursive(int[] sortCandidate, int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            // Find the middle index
            int midIndex = leftBound + (rightBound - leftBound) / 2;

            // Sort left and right separated by middle index
            sortRecursive(sortCandidate, leftBound, midIndex);
            sortRecursive(sortCandidate, midIndex + 1, rightBound);

            // Ascending comparison with merge
            compareAndMerge(sortCandidate, leftBound, midIndex, rightBound);
        }
    }

    private static void compareAndMerge(int[] mergeCandidate, int leftBound, int midIndex, int rightBound) {
        int leftArraySize = midIndex - leftBound + 1;
        int rightArraySize = rightBound - midIndex;

        /* Create temp arrays */
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        /*Copy data to temp arrays*/
        for (int i = 0; i < leftArraySize; ++i)
            leftArray[i] = mergeCandidate[leftBound + i];
        for (int j = 0; j < rightArraySize; ++j)
            rightArray[j] = mergeCandidate[midIndex + 1 + j];



        int mergeIndex = leftBound;   // Where to start merging based on ascending sort
        int indexLeft = 0, indexRight = 0;


        while (indexLeft < leftArraySize && indexRight < rightArraySize) {
            if (leftArray[indexLeft] <= rightArray[indexRight]) {
                mergeCandidate[mergeIndex] = leftArray[indexLeft];
                indexLeft++;
            } else {
                mergeCandidate[mergeIndex] = rightArray[indexRight];
                indexRight++;
            }
            mergeIndex++;
        }

        // Fill mergeCandidate with remaining values of copied arrays
        while (indexLeft < leftArraySize) {
            mergeCandidate[mergeIndex] = leftArray[indexLeft];
            indexLeft++;
            mergeIndex++;
        }
        while (indexRight < rightArraySize) {
            mergeCandidate[mergeIndex] = rightArray[indexRight];
            indexRight++;
            mergeIndex++;
        }
    }

}
