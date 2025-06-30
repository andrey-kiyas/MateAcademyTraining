package MateAcademy.leetcode.LC01Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-harmonious-subsequence
 */

public class LC0594LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7})); // 5
        System.out.println(findLHS(new int[]{1, 2, 3, 4}));             // 2
        System.out.println(findLHS(new int[]{1, 1, 1, 1}));             // 0
    }

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0;
        for (int key : freq.keySet()) {
            if (freq.containsKey(key + 1)) {
                maxLen = Math.max(maxLen, freq.get(key) + freq.get(key + 1));
            }
        }

        return maxLen;
    }
}
