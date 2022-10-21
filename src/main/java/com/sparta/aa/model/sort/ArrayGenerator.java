package com.sparta.aa.model.sort;

import java.util.Random;

public class ArrayGenerator {
    public static int[] generate(int size) {
        Random random = new Random();
        return random.ints(size, -100, 1000).toArray();
    }
}
