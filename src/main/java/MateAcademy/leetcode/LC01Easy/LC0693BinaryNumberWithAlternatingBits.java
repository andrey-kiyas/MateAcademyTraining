package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/binary-number-with-alternating-bits
 */

public class LC0693BinaryNumberWithAlternatingBits {
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));  // true  (101)
        System.out.println(hasAlternatingBits(7));  // false (111)
        System.out.println(hasAlternatingBits(11)); // false (1011)
    }

    public static boolean hasAlternatingBits(int n) {
        int x = n ^ (n >> 1);

        return (x & ((long) x + 1)) == 0;
    }
}