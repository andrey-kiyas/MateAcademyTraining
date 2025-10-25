package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/calculate-money-in-leetcode-bank
 */

public class LC1716CalculateMoneyInLeetcodeBank {
    public static void main(String[] args) {
        System.out.println(totalMoney(4));   // 10
        System.out.println(totalMoney(10));  // 37
        System.out.println(totalMoney(20));  // 96
    }

    public static int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;

        return 7 * (4 * weeks + weeks * (weeks - 1) / 2)
                + days * weeks + days * (days + 1) / 2;
    }
}
