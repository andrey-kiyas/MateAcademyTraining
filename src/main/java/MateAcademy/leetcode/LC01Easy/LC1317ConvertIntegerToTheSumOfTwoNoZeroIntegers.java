package MateAcademy.leetcode.LC01Easy;

/*
  https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers
 */

import java.util.Arrays;

public class LC1317ConvertIntegerToTheSumOfTwoNoZeroIntegers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getNoZeroIntegers(2)));   // [1, 1]
        System.out.println(Arrays.toString(getNoZeroIntegers(11)));  // [2, 9]
        System.out.println(Arrays.toString(getNoZeroIntegers(101))); // [2, 99]
    }

    public static int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;
            if (isNoZero(a) && isNoZero(b)) {
                return new int[]{a, b};
            }
        }
        return new int[]{};
    }

    private static boolean isNoZero(int num) {
        while (num > 0) {
            if (num % 10 == 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
