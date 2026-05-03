package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/rotate-string
 */

public class LC0796RotateString {
    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab")); // true
        System.out.println(rotateString("abcde", "abced")); // false
    }

    public static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        String combined = s + s;

        return combined.contains(goal);
    }
}
