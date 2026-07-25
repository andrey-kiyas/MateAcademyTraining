package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/maximum-product-of-two-digits
 */

public class LC3536MaximumProductOfTwoDigits {
    public static void main(String[] args) {
        System.out.println(maxProduct(31));  // 3
        System.out.println(maxProduct(22));  // 4
        System.out.println(maxProduct(124)); // 8
    }

    public static int maxProduct(int n) {
        int largestDigit = 0;
        int secondLargestDigit = 0;

        while (n > 0) {
            int currentDigit = n % 10;

            if (currentDigit > largestDigit) {
                secondLargestDigit = largestDigit;
                largestDigit = currentDigit;
            } else if (currentDigit > secondLargestDigit) {
                secondLargestDigit = currentDigit;
            }

            n /= 10;
        }

        return largestDigit * secondLargestDigit;
    }
}
