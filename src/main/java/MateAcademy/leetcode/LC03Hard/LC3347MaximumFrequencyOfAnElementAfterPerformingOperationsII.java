package MateAcademy.leetcode.LC03Hard;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-ii
 */

public class LC3347MaximumFrequencyOfAnElementAfterPerformingOperationsII {
    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1, 4, 5}, 1, 2));       // 2
        System.out.println(maxFrequency(new int[]{5, 11, 20, 20}, 5, 1)); // 2
        System.out.println(maxFrequency(new int[]{1, 90}, 76, 1));        // 1
    }

    public static int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        TreeMap<Integer, Integer> rangeBoundaries = new TreeMap<>();

        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
            rangeBoundaries.putIfAbsent(num, 0);
            rangeBoundaries.merge(num - k, 1, Integer::sum);
            rangeBoundaries.merge(num + k + 1, -1, Integer::sum);
        }

        int maxResult = 0;
        int currentOverlap = 0;

        for (Map.Entry<Integer, Integer> entry : rangeBoundaries.entrySet()) {
            int position = entry.getKey();
            int delta = entry.getValue();

            currentOverlap += delta;

            int originalFrequency = frequencyMap.getOrDefault(position, 0);
            int achievableFrequency = Math.min(currentOverlap, originalFrequency + numOperations);

            maxResult = Math.max(maxResult, achievableFrequency);
        }

        return maxResult;
    }
}
