package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/power-of-two
 */

public class LC0231PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));   // true
        System.out.println(isPowerOfTwo(16));  // true
        System.out.println(isPowerOfTwo(3));   // false
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
