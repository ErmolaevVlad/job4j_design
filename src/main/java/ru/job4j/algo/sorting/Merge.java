package ru.job4j.algo.sorting;

import java.util.Arrays;

public class Merge {

    public static int[] mergesort(int[] array) {
        int[] result = array;
        int n = array.length;
        if (n > 1) {
            int[] left = mergesort(Arrays.copyOfRange(array, 0, n / 2));
            int[] right = mergesort(Arrays.copyOfRange(array, n / 2, n));
            result = merge(left, right);
        }
        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int indexLeft = 0;
        int indexRight = 0;
        for (int index = 0; index < result.length; index++) {
            if (indexLeft >= left.length && indexRight < right.length) {
                result[index] = right[indexRight];
                indexRight++;
            } else if (indexRight >= right.length && indexLeft < left.length) {
                result[index] = left[indexLeft];
                indexLeft++;
            } else {
                if (left[indexLeft] < right[indexRight]) {
                    result[index] = left[indexLeft];
                    indexLeft++;
                } else {
                    result[index] = right[indexRight];
                    indexRight++;
                }
            }
        }
        return result;
    }
}