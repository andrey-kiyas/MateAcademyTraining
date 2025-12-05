package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/count-partitions-with-even-sum-difference
 */

public class LC3432CountPartitionsWithEvenSumDifference {
    public static void main(String[] args) {
        System.out.println(countPartitions(new int[]{10, 10, 3, 7, 6})); // 4
        System.out.println(countPartitions(new int[]{1, 2, 2}));         // 0
        System.out.println(countPartitions(new int[]{2, 4, 6, 8}));      // 3
    }

    public static int countPartitions(int[] nums) {
        int sum = 0;
        for (int x : nums) sum += x;
        return (sum % 2 == 0) ? nums.length - 1 : 0;
    }
}
