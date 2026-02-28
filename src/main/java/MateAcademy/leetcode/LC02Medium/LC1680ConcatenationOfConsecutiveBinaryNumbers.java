package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/description
 */

public class LC1680ConcatenationOfConsecutiveBinaryNumbers {
    public static void main(String[] args) {
        System.out.println(concatenatedBinary(1));  // 1
        System.out.println(concatenatedBinary(3));  // 27
        System.out.println(concatenatedBinary(12)); // 505379714
    }

    public static int concatenatedBinary(int n) {
        long MOD = 1_000_000_007;
        long result = 0;
        int currentBitLength = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                currentBitLength++;
            }

            result = ((result << currentBitLength) | i) % MOD;
        }

        return (int) result;
    }
}
