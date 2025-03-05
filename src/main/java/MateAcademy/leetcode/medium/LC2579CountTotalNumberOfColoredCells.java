package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/count-total-number-of-colored-cells
 */

public class LC2579CountTotalNumberOfColoredCells {
    public static void main(String[] args) {
        System.out.println(coloredCells(1)); // 1
        System.out.println(coloredCells(2)); // 5
        System.out.println(coloredCells(3)); // 13
    }

    public static long coloredCells(int n) {
        return 2L * n * (n - 1) + 1;
    }
}
