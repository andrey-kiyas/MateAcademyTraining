package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/rearranging-fruits
 */

public class LC2561RearrangingFruits {
    public static void main(String[] args) {
        System.out.println(minCost(new int[]{4, 2, 2, 2}, new int[]{1, 4, 1, 2})); // 1
        System.out.println(minCost(new int[]{2, 3, 4, 1}, new int[]{3, 2, 5, 1})); // -1
    }

    public static long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> freq = new TreeMap<>();

        for (int fruit : basket1)
            freq.put(fruit, freq.getOrDefault(fruit, 0) + 1);
        for (int fruit : basket2)
            freq.put(fruit, freq.getOrDefault(fruit, 0) - 1);

        List<Integer> extra = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int fruit = entry.getKey(), count = entry.getValue();
            minValue = Math.min(minValue, fruit);

            if (count % 2 != 0) return -1;

            for (int i = 0; i < Math.abs(count) / 2; i++) {
                extra.add(fruit);
            }
        }

        Collections.sort(extra);
        long totalCost = 0;

        for (int i = 0; i < extra.size() / 2; i++) {
            totalCost += Math.min(extra.get(i), minValue * 2L);
        }

        return totalCost;
    }
}
