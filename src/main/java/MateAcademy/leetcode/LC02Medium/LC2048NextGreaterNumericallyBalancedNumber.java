package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/next-greater-numerically-balanced-number
 */

public class LC2048NextGreaterNumericallyBalancedNumber {
    public static void main(String[] args) {
        System.out.println(nextBeautifulNumber(1));     // 22
        System.out.println(nextBeautifulNumber(1000));  // 1333
        System.out.println(nextBeautifulNumber(3000));  // 3133
        System.out.println(nextBeautifulNumber(22));    // 122
    }

    public static int nextBeautifulNumber(int n) {
        int num = n + 1;

        while (true) {
            if (isBalanced(num)) {
                return num;
            }
            num++;
        }
    }

    private static boolean isBalanced(int num) {
        int[] count = new int[10];

        int tmp = num;
        while (tmp > 0) {
            int d = tmp % 10;
            count[d]++;
            tmp /= 10;
        }

        for (int d = 0; d <= 9; d++) {
            if (count[d] > 0 && count[d] != d) {
                return false;
            }
        }

        return true;
    }
}
