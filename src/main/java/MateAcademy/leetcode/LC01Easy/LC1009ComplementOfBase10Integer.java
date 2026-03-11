package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/complement-of-base-10-integer
 */

public class LC1009ComplementOfBase10Integer {
    public static void main(String[] args) {
        System.out.println(bitwiseComplement(5));  // 2
        System.out.println(bitwiseComplement(7));  // 0
        System.out.println(bitwiseComplement(10)); // 5
    }

    public static int bitwiseComplement(int n) {
        if (n == 0) return 1;

        int mask = 0;
        int temp = n;

        while (temp > 0) {
            mask = (mask << 1) | 1;
            temp >>= 1;
        }

        return n ^ mask;
    }
}
