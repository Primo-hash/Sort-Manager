package com.sparta.aa.model.factory;

import com.sparta.aa.controller.sort.BubbleSort;
import com.sparta.aa.controller.sort.MergeSort;
import com.sparta.aa.controller.sort.Sortable;
import com.sparta.aa.model.exception.SorterLoaderException;
import com.sparta.aa.model.sort.Sorter;

public class SortFactory {
    public static Sortable generateSorter(Sorter sorter) throws SorterLoaderException {
        switch (sorter) {
            case BUBBLE -> {
                return new BubbleSort();
            }
            case MERGE -> {
                return new MergeSort();
            }
            default -> throw new SorterLoaderException("Invalid Sorter choice: " + sorter.getName());
        }
    }
}
