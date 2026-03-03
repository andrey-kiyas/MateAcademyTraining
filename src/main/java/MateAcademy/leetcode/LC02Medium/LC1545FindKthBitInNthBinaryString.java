package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/find-kth-bit-in-nth-binary-string
 */

public class LC1545FindKthBitInNthBinaryString {
    public static void main(String[] args) {
        System.out.println(findKthBit(3, 1));  // 0
        System.out.println(findKthBit(4, 11)); // 1
    }

    public static char findKthBit(int n, int k) {
        if (n == 1) return '0';

        int length = (1 << n) - 1;
        int mid = length / 2 + 1;

        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBit(n - 1, k);
        } else {
            char bit = findKthBit(n - 1, length - k + 1);
            return bit == '0' ? '1' : '0';
        }
    }
}
