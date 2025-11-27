package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k
 */

public class LC3381MaximumSubarraySumWithLengthDivisibleByK {
    public static void main(String[] args) {
        System.out.println(maxSubarraySum(new int[]{1, 2}, 1));                 // 3
        System.out.println(maxSubarraySum(new int[]{-1, -2, -3, -4, -5}, 4));   // -10
        System.out.println(maxSubarraySum(new int[]{-5, 1, 2, -3, 4}, 2));      // 4
    }

    public static long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long[] minPref = new long[k];
        for (int i = 0; i < k; i++) minPref[i] = Long.MAX_VALUE;

        long pref = 0;
        long result = Long.MIN_VALUE;

        minPref[0] = 0;

        for (int i = 0; i < n; i++) {
            pref += nums[i];
            int mod = (i + 1) % k;

            if (minPref[mod] != Long.MAX_VALUE) {
                result = Math.max(result, pref - minPref[mod]);
            }

            minPref[mod] = Math.min(minPref[mod], pref);
        }

        return result;
    }
}
