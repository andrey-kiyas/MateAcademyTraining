package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition
 */

public class LC1498NumberOfSubsequencesThatSatisfyTheGivenSumCondition {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(numSubseq(new int[]{3,5,6,7}, 9));      // 4
        System.out.println(numSubseq(new int[]{3,3,6,8}, 10));     // 6
        System.out.println(numSubseq(new int[]{2,3,3,4,6,7}, 12)); // 61
    }

    public static int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1, result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                result = (result + pow[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
