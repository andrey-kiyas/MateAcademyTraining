package MateAcademy.leetcode.LC01Easy;

/*
  https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero
 */

import java.util.Arrays;

public class LC1304FindNUniqueIntegersSumUpToZero {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(5))); // [-1, 1, -2, 2, 0]
        System.out.println(Arrays.toString(sumZero(3))); // [-1, 1, 0]
        System.out.println(Arrays.toString(sumZero(1))); // [0]
    }

    public static int[] sumZero(int n) {
        int[] result = new int[n];
        int index = 0;

        for (int i = 1; i <= n / 2; i++) {
            result[index++] = -i;
            result[index++] = i;
        }

        if (n % 2 == 1) {
            result[index] = 0;
        }

        return result;
    }
}
