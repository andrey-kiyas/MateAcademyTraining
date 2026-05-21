package MateAcademy.leetcode.LC02Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix
 */

public class LC3043FindTheLengthOfTheLongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new int[]{1, 10, 100}, new int[]{1000})); // 3
        System.out.println(longestCommonPrefix(new int[]{1, 2, 3}, new int[]{4, 4, 4})); // 0
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet<>();

        for (int val : arr1) {
            while (val > 0) {
                prefixes.add(val);
                val /= 10;
            }
        }

        int maxLength = 0;

        for (int val : arr2) {
            while (val > 0) {
                int currentLength = String.valueOf(val).length();
                if (currentLength <= maxLength) {
                    break;
                }

                if (prefixes.contains(val)) {
                    maxLength = currentLength;
                    break;
                }
                val /= 10;
            }
        }

        return maxLength;
    }
}
