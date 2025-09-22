package MateAcademy.leetcode.LC01Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-elements-with-maximum-frequency
 */

public class LC3005CountElementsWithMaximumFrequency {
    public static void main(String[] args) {
        System.out.println(maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4})); // 4
        System.out.println(maxFrequencyElements(new int[]{1, 2, 3, 4, 5}));    // 5
    }

    public static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        int maxFreq = 0;
        for (int num : nums) {
            int newFreq = freqMap.getOrDefault(num, 0) + 1;
            freqMap.put(num, newFreq);
            maxFreq = Math.max(maxFreq, newFreq);
        }

        int count = 0;
        for (int freq : freqMap.values()) {
            if (freq == maxFreq) {
                count += freq;
            }
        }

        return count;
    }
}
