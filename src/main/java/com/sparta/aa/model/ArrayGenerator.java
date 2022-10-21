package com.sparta.aa.model;

import java.util.Random;

public class ArrayGenerator {
    public static int[] generateRandomIntArray(int size, int minVal, int maxVal) throws NullPointerException {
        // TODO custom exception here for maximum array size and minimum/maximum array values (should be max integer value / 1000)
        Random random = new Random();
        return random.ints(size, -100, 1000).toArray();
    }
}
