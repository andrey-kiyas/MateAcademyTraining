package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-i
 */

public class LC3346MaximumFrequencyOfAnElementAfterPerformingOperationsI {
    public static void main(String[] args) {
        System.out.println(maxFrequency(new int[]{1, 4, 5}, 1, 2));       // 2
        System.out.println(maxFrequency(new int[]{5, 11, 20, 20}, 5, 1)); // 2
    }

    public static int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        TreeMap<Integer, Integer> differenceArray = new TreeMap<>();

        for (int num : nums) {
            frequencyMap.merge(num, 1, Integer::sum);
            differenceArray.putIfAbsent(num, 0);
            differenceArray.merge(num - k, 1, Integer::sum);
            differenceArray.merge(num + k + 1, -1, Integer::sum);
        }

        int maxResult = 0;
        int currentOverlappingRanges = 0;

        for (Map.Entry<Integer, Integer> entry : differenceArray.entrySet()) {
            int position = entry.getKey();
            int deltaValue = entry.getValue();
            currentOverlappingRanges += deltaValue;

            int achievableFrequency = Math.min(
                    currentOverlappingRanges,
                    frequencyMap.getOrDefault(position, 0) + numOperations
            );

            maxResult = Math.max(maxResult, achievableFrequency);
        }

        return maxResult;
    }
}
