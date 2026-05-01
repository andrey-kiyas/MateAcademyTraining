package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/rotate-function
 */

public class LC0396RotateFunction {
    public static void main(String[] args) {
        System.out.println(maxRotateFunction(new int[]{4, 3, 2, 6})); // 26
        System.out.println(maxRotateFunction(new int[]{100}));        // 0
    }

    public static int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long sum = 0;
        long f = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += (long) i * nums[i];
        }

        long maxVal = f;

        for (int k = 1; k < n; k++) {
            f = f + sum - (long) n * nums[n - k];
            maxVal = Math.max(maxVal, f);
        }

        return (int) maxVal;
    }
}
