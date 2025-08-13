package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/power-of-three
 */

public class LC0326PowerOfThree {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));  // true
        System.out.println(isPowerOfThree(0));   // false
        System.out.println(isPowerOfThree(-1));  // false
    }

    public static boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
