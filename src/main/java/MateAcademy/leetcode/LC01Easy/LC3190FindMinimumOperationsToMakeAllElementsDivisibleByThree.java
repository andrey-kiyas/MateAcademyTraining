package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three
 */

public class LC3190FindMinimumOperationsToMakeAllElementsDivisibleByThree {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1, 2, 3, 4})); // 3
        System.out.println(minimumOperations(new int[]{3, 6, 9}));    // 0
    }

    public static int minimumOperations(int[] nums) {
        int ops = 0;

        for (int x : nums) {
            if (x % 3 != 0) ops++;
        }

        return ops;
    }
}
