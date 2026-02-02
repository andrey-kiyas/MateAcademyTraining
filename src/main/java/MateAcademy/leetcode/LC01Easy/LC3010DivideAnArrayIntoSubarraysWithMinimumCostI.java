package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-i/description
 */

public class LC3010DivideAnArrayIntoSubarraysWithMinimumCostI {
    public static void main(String[] args) {
        System.out.println(minimumCost(new int[]{1, 2, 3, 12}));
        System.out.println(minimumCost(new int[]{5, 4, 3}));
        System.out.println(minimumCost(new int[]{10, 3, 1, 1}));
    }

    public static int minimumCost(int[] nums) {
        int n = nums.length;
        int firstCost = nums[0];

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            if (nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if (nums[i] < min2) {
                min2 = nums[i];
            }
        }

        return firstCost + min1 + min2;
    }
}
