package MateAcademy.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/largest-divisible-subset
 */

public class LC0368LargestDivisibleSubset {
    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3}));    // [1,2]
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 4, 8})); // [1,2,4,8]
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] prev = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        int k = maxIndex;
        while (k >= 0) {
            result.add(nums[k]);
            k = prev[k];
        }

        Collections.reverse(result);
        return result;
    }
}
