package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/find-the-maximum-sum-of-node-values
 */

public class LC3068FindTheMaximumSumOfNodeValues {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1};
        int[][] edges1 = {{0, 1}, {0, 2}};
        int k1 = 3;
        System.out.println(maximumValueSum(nums1, k1, edges1)); // 6

        int[] nums2 = {2, 3};
        int[][] edges2 = {{0, 1}};
        int k2 = 7;
        System.out.println(maximumValueSum(nums2, k2, edges2)); // 9

        int[] nums3 = {7, 7, 7, 7, 7, 7};
        int[][] edges3 = {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}};
        int k3 = 3;
        System.out.println(maximumValueSum(nums3, k3, edges3)); // 42
    }

    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        long withoutXor = 0;
        long withXor = Long.MIN_VALUE;

        for (int num : nums) {
            long temp = withoutXor;

            withoutXor = Math.max(withoutXor + num, withXor + (num ^ k));
            withXor = Math.max(withXor + num, temp + (num ^ k));
        }

        return withoutXor;
    }

    public static long maximumValueSum2(int[] nums, int k, int[][] edges) {
        long f0 = 0, f1 = -0x3f3f3f3f;
        for (int x : nums) {
            long tmp = f0;
            f0 = Math.max(f0 + x, f1 + (x ^ k));
            f1 = Math.max(f1 + x, tmp + (x ^ k));
        }
        return f0;
    }
}
