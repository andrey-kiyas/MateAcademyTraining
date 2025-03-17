package MateAcademy.leetcode.easy;

/**
 * https://leetcode.com/problems/divide-array-into-equal-pairs
 */

public class LC2206DivideArrayIntoEqualPairs {
    public static void main(String[] args) {
        System.out.println(divideArray(new int[]{3, 2, 3, 2, 2, 2})); // true
        System.out.println(divideArray(new int[]{1, 2, 3, 4}));       // false
    }

    public static boolean divideArray(int[] nums) {
        int[] count = new int[501];

        for (int num : nums) {
            count[num]++;
        }

        for (int c : count) {
            if (c % 2 != 0) {
                return false;
            }
        }

        return true;
    }
}
