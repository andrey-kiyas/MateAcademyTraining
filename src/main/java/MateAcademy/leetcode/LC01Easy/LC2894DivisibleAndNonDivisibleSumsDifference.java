package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/divisible-and-non-divisible-sums-difference
 */

public class LC2894DivisibleAndNonDivisibleSumsDifference {
    public static void main(String[] args) {
        System.out.println(differenceOfSums(10, 3)); // 19
        System.out.println(differenceOfSums(5, 6));  // 15
        System.out.println(differenceOfSums(5, 1));  // -15
    }

    public static int differenceOfSums(int n, int m) {
        int num1 = 0;
        int num2 = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                num2 += i;
            } else {
                num1 += i;
            }
        }

        return num1 - num2;
    }
}
