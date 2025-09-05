package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-the-integer-zero
 */

public class LC2749MinimumOperationsToMakeTheIntegerZero {
    public static void main(String[] args) {
        System.out.println(makeTheIntegerZero(3, -2)); // 3
        System.out.println(makeTheIntegerZero(5, 7));  // -1
    }

    public static int makeTheIntegerZero(int num1, int num2) {
        for (int k = 1; k <= 60; k++) {
            long target = (long) num1 - (long) num2 * k;
            if (target < 0) continue;

            int bits = Long.bitCount(target);
            if (bits <= k && k <= target) {
                return k;
            }
        }
        return -1;
    }
}
