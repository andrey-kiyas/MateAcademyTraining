package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k
 */

public class LC2311LongestBinarySubsequenceLessThanOrEqualToK {
    public static void main(String[] args) {
        System.out.println(longestSubsequence("1001010", 5));  // 5
        System.out.println(longestSubsequence("00101001", 1)); // 6
    }

    public static int longestSubsequence(String s, int k) {
        int longestLength = 0;
        int decimalValue = 0;

        for (int index = s.length() - 1; index >= 0; --index) {
            if (s.charAt(index) == '0') {
                ++longestLength;
            }
            else if (longestLength < 30 && (decimalValue | (1 << longestLength)) <= k) {
                decimalValue |= 1 << longestLength;
                ++longestLength;
            }
        }
        return longestLength;
    }
}
