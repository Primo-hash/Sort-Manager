package com.sparta.aa.controller;

import com.sparta.aa.controller.sort.MergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;


/**
 * We're testing the BubbleSort class by creating a new unsorted array before each test, and then testing that the
 * BubbleSort.sort() method returns a sorted array.
 */
public class MergeSortTest {

    static int[] unsortedIntArray;    // Unsorted array
    static MergeSort mergeSort = new MergeSort();
    Random random = new Random();

    @BeforeEach
    public void setNewUnsortedIntArray() {
        unsortedIntArray = random.ints(15, -20, 100).toArray();
    }

    @Test
    @DisplayName("Check that empty array returns empty array")
    void checkThatEmptyArrayReturnsEmptyArray() {
        int[] arr = new int[0];
        Assertions.assertArrayEquals(arr, mergeSort.sort(arr));
    }

    @Test
    @DisplayName("Check that single element array returns single element array")
    void checkThatSingleElementArrayReturnsArray() {
        int[] arr = {1};
        Assertions.assertArrayEquals(arr, mergeSort.sort(arr));
    }

    @Test
    @DisplayName("Check that unsorted array returns sorted array")
    void checkThatUnsortedArrayReturnsSortedArray() {
        int[] arr = {7,5,4,3,2,1,8,6};
        Assertions.assertArrayEquals(new int[]{1,2,3,4,5,6,7,8}, mergeSort.sort(arr));
    }

    @Test
    @DisplayName("Check that odd sized array returns sorted array")
    void checkThatOddSizedArrayReturnsSortedArray() {
        int[] arr = {7,5,4,3,2,1,8,6,9};
        Assertions.assertArrayEquals(new int[]{1,2,3,4,5,6,7,8,9}, mergeSort.sort(arr));
    }

    @Test
    @DisplayName("Check that array with negative ints returns sorted array")
    void checkThatNegativeElementArrayReturnsSortedArray() {
        int[] arr = {-6, -5, -4, 0, 5, 7, 8, 2, 4, 1};
        Assertions.assertArrayEquals(new int[]{-6, -5, -4, 0, 1, 2, 4, 5, 7, 8}, mergeSort.sort(arr));
    }

    @Test
    @DisplayName("Check that array with same ints returns sorted array")
    void checkThatSameElementArrayReturnsSortedArray() {
        int[] arr = {-6, -5, -4, 0, 5, 5, 5, 5, 2, 4, 1};
        Assertions.assertArrayEquals(new int[]{-6, -5, -4, 0, 1, 2, 4, 5, 5, 5, 5}, mergeSort.sort(arr));
    }

    @Test
    @DisplayName("Check that randomized array returns sorted array")
    void checkThatRandomArrayReturnsSortedArray() {
        int[] arrayCopy = unsortedIntArray.clone();
        Arrays.sort(arrayCopy);

        Assertions.assertArrayEquals(arrayCopy, mergeSort.sort(unsortedIntArray));
    }

    @Test
    @DisplayName("Check that large array returns sorted array")
    void checkThatLargeArrayReturnsSortedArray() {
        unsortedIntArray = random.ints(1000, -20, 100).toArray();
        int[] arrayCopy = unsortedIntArray.clone();
        Arrays.sort(arrayCopy);

        Assertions.assertArrayEquals(arrayCopy, mergeSort.sort(unsortedIntArray));
    }
}
