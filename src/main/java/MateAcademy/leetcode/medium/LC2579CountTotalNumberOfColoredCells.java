package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/count-total-number-of-colored-cells
 */

public class LC2579CountTotalNumberOfColoredCells {
    public static void main(String[] args) {

//        Input: n = 1
//        Output: 1
//        Explanation: After 1 minute, there is only 1 blue cell, so we return 1.
//        Example 2:
//
//        Input: n = 2
//        Output: 5


        System.out.println(coloredCells(1));
        System.out.println(coloredCells(2));

    }

    public static long coloredCells(int n) {
        return 2L * n * (n - 1) + 1;
    }
}
