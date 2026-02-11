package MateAcademy.leetcode.LC02Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-balanced-subarray-i
 */

public class LC3719LongestBalancedSubarrayI {
    public static void main(String[] args) {
        System.out.println(longestBalanced(new int[]{2, 5, 4, 3}));    // Output: 4
        System.out.println(longestBalanced(new int[]{3, 2, 2, 5, 4})); // Output: 5
        System.out.println(longestBalanced(new int[]{1, 2, 3, 2}));    // Output: 3
    }

    public static int longestBalanced(int[] nums) {
        int maxLength = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            Set<Integer> distinctEvens = new HashSet<>();
            Set<Integer> distinctOdds = new HashSet<>();

            for (int j = i; j < n; j++) {
                if (nums[j] % 2 == 0) {
                    distinctEvens.add(nums[j]);
                } else {
                    distinctOdds.add(nums[j]);
                }

                if (distinctEvens.size() == distinctOdds.size()) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
}
