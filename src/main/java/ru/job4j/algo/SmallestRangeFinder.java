package ru.job4j.algo;

import java.util.Arrays;

public class SmallestRangeFinder {
    public static int[] findSmallestRange(int[] nums, int k) {
        int i = 0;
        int j = 1;
        int indexFirst = 0;
        int countDifferentElements = 0;
        int[] rsl = new int[2];
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                indexFirst = j;
                i = j;
                j++;
                countDifferentElements = 0;
            } else {
                countDifferentElements++;
                i++;
                j++;
            }
            if (countDifferentElements == k - 1) {
                break;
            }
        }
        if (countDifferentElements != 0) {
            rsl[0] = indexFirst;
            rsl[1] = j - 1;
        } else {
            rsl = null;
        }
        return rsl;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}
