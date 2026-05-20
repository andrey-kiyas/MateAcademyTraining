package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays
 */

public class LC2657FindThePrefixCommonArrayOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findThePrefixCommonArray(new int[]{1, 3, 2, 4}, new int[]{3, 1, 2, 4}))); // [0, 2, 3, 4]
        System.out.println(Arrays.toString(findThePrefixCommonArray(new int[]{2, 3, 1}, new int[]{3, 1, 2})));       // [0, 1, 3]
    }

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];

        int[] counts = new int[n + 1];
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            counts[A[i]]++;
            if (counts[A[i]] == 2) {
                commonCount++;
            }

            counts[B[i]]++;
            if (counts[B[i]] == 2) {
                commonCount++;
            }

            C[i] = commonCount;
        }

        return C;
    }
}
