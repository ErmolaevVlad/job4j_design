package ru.job4j.algo.sorting;

import java.util.*;

class IntervalMerger {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> rsl = new ArrayList<>();
        int[] currentInterval = intervals[0];
        rsl.add(currentInterval);
        for (int index = 1; index < intervals.length; index++) {
            if (intervals[index][0] <= currentInterval[1]) {
                currentInterval[1] = Math.max(currentInterval[1], intervals[index][1]);
            } else {
                currentInterval = intervals[index];
                rsl.add(currentInterval);
            }
        }
        return rsl.toArray(new int[][]{});
    }
}