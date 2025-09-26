package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/valid-triangle-number
 */

public class LC0611ValidTriangleNumber {
    public static void main(String[] args) {
        System.out.println(triangleNumber(new int[]{2, 2, 3, 4})); // 3
        System.out.println(triangleNumber(new int[]{4, 2, 3, 4})); // 4
    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }

        return count;
    }
}
