package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/xor-after-range-multiplication-queries-i
 */

public class LC3653XORAfterRangeMultiplicationQueriesI {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int[][] q1 = {{0, 2, 1, 4}};
        System.out.println(xorAfterQueries(nums1, q1)); // 4

        int[] nums2 = {2, 3, 1, 5, 4};
        int[][] q2 = {{1, 4, 2, 3}, {0, 2, 1, 2}};
        System.out.println(xorAfterQueries(nums2, q2)); // 31
    }

    public static int xorAfterQueries(int[] nums, int[][] queries) {
        long MOD = 1_000_000_007L;

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            long v = query[3];

            for (int idx = l; idx <= r; idx += k) {
                long current = nums[idx];
                nums[idx] = (int) ((current * v) % MOD);
            }
        }

        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
