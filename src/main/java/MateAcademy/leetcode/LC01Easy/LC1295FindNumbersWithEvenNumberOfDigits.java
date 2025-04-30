package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/find-numbers-with-even-number-of-digits
 */

public class LC1295FindNumbersWithEvenNumberOfDigits {
    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{12, 345, 2, 6, 7896})); // 2
        System.out.println(findNumbers(new int[]{555, 901, 482, 1771})); // 1
    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
