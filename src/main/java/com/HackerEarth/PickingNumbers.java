package com.HackerEarth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PickingNumbers {

    public static void main(String[] args) throws Exception {

        int[] array = {1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4};
        System.out.println(pickingNumbers(array));

    }

    static int pickingNumbers(int[] a) {

        Arrays.sort(a);
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int x : a) {
            Integer mapInteger = map.get(x);
            if (mapInteger == null) {
                map.put(x, 1);
            } else {
                map.put(x, mapInteger + 1);
            }
        }

        if (map.size() <= 1) {

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

                return entry.getValue();

            }

        } else if (map.size() <= 2) {

            int max = -1;
            int first = -1;
            int second = -1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

                if (first == -1) {
                    first = entry.getKey();
                } else if (second == -1) {
                    second = entry.getKey();
                }

            }

            if (Math.abs(first - second) > 1) {

                return map.get(Math.max(first, second));

            } else {

                return map.get(first) + map.get(second);

            }

        } else {

            int maxSum = -1;
            int maxValue = -1;
            int first = -1;
            int second = -1;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

                if (entry.getValue() > maxValue) {
                    maxValue = entry.getValue();
                }

                if (first == -1) {
                    first = entry.getKey();
                    continue;
                } else if (second == -1) {
                    second = entry.getKey();
                    continue;
                }

                if (first != -1 && second != -1) {

                    if (Math.abs(first - second) <= 1) {

                        if (maxSum < (map.get(first) + map.get(second))) {
                            maxSum = map.get(first) + map.get(second);
                        }

                    }

                    first = second;
                    second = entry.getKey();

                }

            }

            if (first != -1 && second != -1) {

                if (Math.abs(first - second) <= 1) {

                    if (maxSum < (map.get(first) + map.get(second))) {
                        maxSum = map.get(first) + map.get(second);
                    }

                }

            }

            if (maxSum > maxValue) {
                return maxSum;
            } else return maxValue;

        }
        return 0;
    }
}
