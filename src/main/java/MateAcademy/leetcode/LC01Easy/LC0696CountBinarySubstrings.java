package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/count-binary-substrings
 */

public class LC0696CountBinarySubstrings {
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011")); // 6
        System.out.println(countBinarySubstrings("10101"));    // 4
    }

    public static int countBinarySubstrings(String s) {
        int count = 0;
        int prevGroupLen = 0;
        int curGroupLen = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curGroupLen++;
            } else {
                count += Math.min(prevGroupLen, curGroupLen);

                prevGroupLen = curGroupLen;
                curGroupLen = 1;
            }
        }

        return count + Math.min(prevGroupLen, curGroupLen);
    }
}
