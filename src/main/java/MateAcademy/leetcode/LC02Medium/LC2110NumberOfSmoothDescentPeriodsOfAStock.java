package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock
 */

public class LC2110NumberOfSmoothDescentPeriodsOfAStock {
    public static void main(String[] args) {
        System.out.println(getDescentPeriods(new int[]{3, 2, 1, 4})); // 7
        System.out.println(getDescentPeriods(new int[]{8, 6, 7, 7})); // 4
        System.out.println(getDescentPeriods(new int[]{1}));          // 1
    }

    public static long getDescentPeriods(int[] prices) {
        long result = 0;
        long len = 0;

        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i - 1] - prices[i] == 1) {
                len++;
            } else {
                len = 1;
            }
            result += len;
        }

        return result;
    }
}
