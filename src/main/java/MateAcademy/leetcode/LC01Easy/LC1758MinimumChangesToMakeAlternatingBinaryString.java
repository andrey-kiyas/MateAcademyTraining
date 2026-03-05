package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string
 */

public class LC1758MinimumChangesToMakeAlternatingBinaryString {
    public static void main(String[] args) {
        System.out.println(minOperations("0100")); // 1
        System.out.println(minOperations("10"));   // 0
        System.out.println(minOperations("1111")); // 2
    }

    public static int minOperations(String s) {
        int n = s.length();
        int countStart0 = 0;

        for (int i = 0; i < n; i++) {
            char expected = (i % 2 == 0) ? '0' : '1';

            if (s.charAt(i) != expected) {
                countStart0++;
            }
        }

        return Math.min(countStart0, n - countStart0);
    }
}
