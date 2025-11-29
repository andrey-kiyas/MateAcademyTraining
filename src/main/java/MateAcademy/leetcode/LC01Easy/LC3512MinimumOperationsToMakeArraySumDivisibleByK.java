package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k
 */

public class LC3512MinimumOperationsToMakeArraySumDivisibleByK {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{3, 9, 7}, 5)); // 4
        System.out.println(minOperations(new int[]{4, 1, 3}, 4)); // 0
        System.out.println(minOperations(new int[]{3, 2}, 6));    // 5
    }

    public static int minOperations(int[] nums, int k) {
        int sum = 0;

        for (int x : nums) sum += x;

        return sum % k;
    }
}
