package MateAcademy.leetcode.easy;

/**
 * https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer
 */

public class LC2529MaximumCountOfPositiveIntegerAndNegativeInteger {
    public static void main(String[] args) {
        System.out.println(maximumCount(new int[]{-2, -1, -1, 1, 2, 3}));    // 3
        System.out.println(maximumCount(new int[]{-3, -2, -1, 0, 0, 1, 2})); // 3
        System.out.println(maximumCount(new int[]{5, 20, 66, 1314}));        // 4
    }

    public static int maximumCount(int[] nums) {
        int neg = 0, pos = 0;

        for (int num : nums) {
            if (num < 0) neg++;
            else if (num > 0) pos++;
        }

        return Math.max(neg, pos);
    }
}
