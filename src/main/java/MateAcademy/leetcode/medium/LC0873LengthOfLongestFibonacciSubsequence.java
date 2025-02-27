package MateAcademy.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/length-of-longest-fibonacci-subsequence
 */

public class LC0873LengthOfLongestFibonacciSubsequence {
    public static void main(String[] args) {
        System.out.println(lenLongestFibSubseq(new int[]{1,2,3,4,5,6,7,8}));
        System.out.println(lenLongestFibSubseq(new int[]{1,3,7,11,12,14,18}));
    }

    public static int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> index = new HashMap<>();
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            index.put(arr[i], i);
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int prev = arr[j] - arr[i];

                if (prev < arr[i] && index.containsKey(prev)) {
                    int k = index.get(prev);
                    int len = dp.getOrDefault(k * n + i, 2) + 1;
                    dp.put(i * n + j, len);
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen >= 3 ? maxLen : 0;
    }
}
