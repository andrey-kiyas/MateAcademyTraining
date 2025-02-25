package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum
 */

public class LC1524NumberOfSubArraysWithOddSum {
    public static void main(String[] args) {
        System.out.println(numOfSubarrays(new int[]{1, 3, 5}));             // 4
        System.out.println(numOfSubarrays(new int[]{2, 4, 6}));             // 0
        System.out.println(numOfSubarrays(new int[]{1, 2, 3, 4, 5, 6, 7})); // 16
    }

    public static int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int odd_prefix = 0, even_prefix = 1;
        int prefixSum = 0, count = 0;

        for (int num : arr) {
            prefixSum += num;
            if (prefixSum % 2 == 0) {
                count = (count + odd_prefix) % MOD;
                even_prefix++;
            } else {
                count = (count + even_prefix) % MOD;
                odd_prefix++;
            }
        }

        return count;
    }
}
