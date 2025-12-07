package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/count-odd-numbers-in-an-interval-range
 */

public class LC1523CountOddNumbersInAnIntervalRange {
    public static void main(String[] args) {
        System.out.println(countOdds(3, 7));   // 3
        System.out.println(countOdds(8, 10));  // 1
    }

    public static int countOdds(int low, int high) {
        return (high + 1) / 2 - low / 2;
    }
}
