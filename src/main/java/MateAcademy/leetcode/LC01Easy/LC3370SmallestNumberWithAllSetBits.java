package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/smallest-number-with-all-set-bits
 */

public class LC3370SmallestNumberWithAllSetBits {
    public static void main(String[] args) {
        System.out.println(smallestNumber(5));   // 7
        System.out.println(smallestNumber(10));  // 15
        System.out.println(smallestNumber(3));   // 3
    }

    public static int smallestNumber(int n) {
        int x = 1;
        while (x < n) {
            x = (x << 1) | 1;
        }
        return x;
    }
}
