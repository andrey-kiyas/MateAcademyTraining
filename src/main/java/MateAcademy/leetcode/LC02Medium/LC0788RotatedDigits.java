package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/rotated-digits
 */

public class LC0788RotatedDigits {
    public static void main(String[] args) {
        System.out.println(rotatedDigits(10)); // 4
        System.out.println(rotatedDigits(1));  // 0
        System.out.println(rotatedDigits(2));  // 1
    }

    public static int rotatedDigits(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isGood(int num) {
        boolean hasTransformer = false;

        while (num > 0) {
            int digit = num % 10;

            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }

            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                hasTransformer = true;
            }

            num /= 10;
        }

        return hasTransformer;
    }
}
