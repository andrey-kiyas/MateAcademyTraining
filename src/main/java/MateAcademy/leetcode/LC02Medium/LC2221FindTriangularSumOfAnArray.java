package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/find-triangular-sum-of-an-array
 */

public class LC2221FindTriangularSumOfAnArray {
    public static void main(String[] args) {
        System.out.println(triangularSum(new int[]{1, 2, 3, 4, 5})); // 8
        System.out.println(triangularSum(new int[]{5}));             // 5
        System.out.println(triangularSum(new int[]{9, 1, 1}));       // 1
    }

    public static int triangularSum(int[] nums) {
        int n = nums.length;

        while (n > 1) {
            for (int i = 0; i < n - 1; i++) {
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            n--;
        }

        return nums[0];
    }
}
