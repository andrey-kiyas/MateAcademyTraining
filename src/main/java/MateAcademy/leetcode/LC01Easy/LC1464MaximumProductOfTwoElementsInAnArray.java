package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array
 */

public class LC1464MaximumProductOfTwoElementsInAnArray {
    public static void main(String[] args) {
            System.out.println(maxProduct(new int[]{3, 4, 5, 2})); // 12
            System.out.println(maxProduct(new int[]{1, 5, 4, 5})); // 16
            System.out.println(maxProduct(new int[]{3, 7}));       // 12
        }

    public static int maxProduct(int[] nums) {
        int max1 = 0;
        int max2 = 0;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}
