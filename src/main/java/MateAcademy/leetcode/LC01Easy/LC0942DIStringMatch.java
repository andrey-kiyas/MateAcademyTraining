package MateAcademy.leetcode.LC01Easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/di-string-match
 */

public class LC0942DIStringMatch {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDID"))); // [0, 4, 1, 3, 2]
        System.out.println(Arrays.toString(diStringMatch("III")));  // [0, 1, 2, 3]
        System.out.println(Arrays.toString(diStringMatch("DDI")));  // [3, 2, 0, 1]
    }

    public static int[] diStringMatch(String s) {
        int n = s.length();
        int[] result = new int[n + 1];
        int low = 0, high = n;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                result[i] = low++;
            } else {
                result[i] = high--;
            }
        }
        result[n] = low;

        return result;
    }
}
