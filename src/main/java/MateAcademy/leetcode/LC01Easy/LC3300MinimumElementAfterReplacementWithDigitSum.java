package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum
 */

public class LC3300MinimumElementAfterReplacementWithDigitSum {
    public static void main(String[] args) {
        System.out.println(minElement(new int[]{10, 12, 13, 14})); // 1
        System.out.println(minElement(new int[]{1, 2, 3, 4}));     // 1
        System.out.println(minElement(new int[]{999, 19, 199}));   // 10
    }

    public static int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            int digitSum = getDigitSum(num);
            if (digitSum < min) {
                min = digitSum;
            }
        }

        return min;
    }

    private static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
