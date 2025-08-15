package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/power-of-four
 */

public class LC0342PowerOfFour {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16)); // true
        System.out.println(isPowerOfFour(5));  // false
        System.out.println(isPowerOfFour(1));  // true
    }

    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
