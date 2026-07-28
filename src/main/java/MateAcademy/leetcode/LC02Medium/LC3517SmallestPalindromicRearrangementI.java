package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/smallest-palindromic-rearrangement-i
 */

public class LC3517SmallestPalindromicRearrangementI {
    public static void main(String[] args) {
        System.out.println(smallestPalindrome("z"));      // z
        System.out.println(smallestPalindrome("babab"));  // abbba
        System.out.println(smallestPalindrome("daccad")); // acddca
    }

    public static String smallestPalindrome(String s) {
        int n = s.length();
        int halfLen = n / 2;

        char[] left = s.substring(0, halfLen).toCharArray();

        Arrays.sort(left);

        StringBuilder sb = new StringBuilder();

        sb.append(left);

        if (n % 2 != 0) {
            sb.append(s.charAt(halfLen));
        }

        for (int i = halfLen - 1; i >= 0; i--) {
            sb.append(left[i]);
        }

        return sb.toString();
    }
}
