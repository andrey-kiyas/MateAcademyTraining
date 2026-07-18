package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/find-greatest-common-divisor-of-array
 */

public class LC1979FindGreatestCommonDivisorOfArray {
    public static void main(String[] args) {
        System.out.println(findGCD(new int[]{2, 5, 6, 9, 10})); // 2
        System.out.println(findGCD(new int[]{7, 5, 6, 8, 3}));  // 1
        System.out.println(findGCD(new int[]{3, 3}));           // 3
    }

    public static int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];

        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        return gcd(min, max);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
