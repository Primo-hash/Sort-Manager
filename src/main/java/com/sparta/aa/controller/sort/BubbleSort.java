package com.sparta.aa.controller.sort;


public class BubbleSort {
    
    /**
     * Sorts an int Array using the BubbleSort method
     *
     * @param unsorted the array to be sorted
     * @return the sorted array
     */
    public static int[] sort(int[] unsorted) {
        boolean sorted = false;                                 // Initialize sorting check to minimize sorting cycles
        int[] numbers = unsorted;                               // Copy of unsorted numbers

        if (numbers != null && numbers.length > 1) {
            while (!sorted) {
                sorted = true;                                  // Assume array has been sorted every new cycle

                for (int i = 0; i < numbers.length - 1; i++) {
                    if (numbers[i] > numbers[i+1]) {
                        sorted = false;                         // Rectify assumption when unsorted element found
                        swap(numbers, i, i+1);
                    }
                }
            }
        }

        return numbers;
    }

    /**
     * Swap the values of the first and second elements in the numbers array.
     *
     * @param numbers the array of numbers to sort
     * @param first the index of the first element to swap
     * @param second the index of the second element to swap
     */
    private static void swap(int[] numbers, int first, int second) {
        int temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }
}
