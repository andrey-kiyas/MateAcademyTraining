package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating
 */

public class LC1888MinimumNumberOfFlipsToMakeTheBinaryStringAlternating {
    public static void main(String[] args) {
        System.out.println(minFlips("111000")); // 2
        System.out.println(minFlips("010"));    // 0
        System.out.println(minFlips("1110"));   // 1
    }

    public static int minFlips(String s) {
        int n = s.length();
        String doubled = s + s;

        StringBuilder t1 = new StringBuilder();
        StringBuilder t2 = new StringBuilder();
        for (int i = 0; i < doubled.length(); i++) {
            t1.append(i % 2 == 0 ? '0' : '1');
            t2.append(i % 2 == 0 ? '1' : '0');
        }

        int diff1 = 0, diff2 = 0;
        int minFlips = Integer.MAX_VALUE;

        for (int i = 0; i < doubled.length(); i++) {
            if (doubled.charAt(i) != t1.charAt(i)) diff1++;
            if (doubled.charAt(i) != t2.charAt(i)) diff2++;

            if (i >= n) {
                int left = i - n;
                if (doubled.charAt(left) != t1.charAt(left)) diff1--;
                if (doubled.charAt(left) != t2.charAt(left)) diff2--;
            }

            if (i >= n - 1) {
                minFlips = Math.min(minFlips, Math.min(diff1, diff2));
            }
        }

        return minFlips;
    }
}
