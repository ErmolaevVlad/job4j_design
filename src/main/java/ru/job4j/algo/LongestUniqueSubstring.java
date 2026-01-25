package ru.job4j.algo;

import java.util.HashMap;
import java.util.Map;

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String str) {
        String rsl = "";
        if (str != null && !str.isEmpty()) {
            int leftIndex = 0;
            int start = 0;
            int end = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (int rightIndex = 0; rightIndex < str.length(); rightIndex++) {
                char currentChar = str.charAt(rightIndex);
                if (map.containsKey(currentChar)) {
                    leftIndex = Math.max(map.get(currentChar) + 1, leftIndex);
                }
                if (rightIndex - leftIndex > end - start) {
                    start = leftIndex;
                    end = rightIndex;
                }
                map.put(currentChar, rightIndex);
            }
            rsl = str.substring(start, end + 1);
        }
        return rsl;
    }
}