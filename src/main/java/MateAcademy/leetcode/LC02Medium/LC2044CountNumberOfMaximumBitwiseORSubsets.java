package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets
 */

public class LC2044CountNumberOfMaximumBitwiseORSubsets {
    static int maxOr = 0;
    static int count = 0;

    public static void main(String[] args) {
        int[] nums1 = {3, 1};
        int[] nums2 = {2, 2, 2};
        int[] nums3 = {3, 2, 1, 5};

        System.out.println(countMaxOrSubsets(nums1)); // 2
        System.out.println(countMaxOrSubsets(nums2)); // 7
        System.out.println(countMaxOrSubsets(nums3)); // 6
    }

    public static int countMaxOrSubsets(int[] nums) {
        maxOr = 0;
        count = 0;
        for (int num : nums) {
            maxOr |= num;
        }
        dfs(nums, 0, 0);
        return count;
    }

    private static void dfs(int[] nums, int index, int currentOr) {
        if (index == nums.length) {
            if (currentOr == maxOr) {
                count++;
            }
            return;
        }
        dfs(nums, index + 1, currentOr | nums[index]);
        dfs(nums, index + 1, currentOr);
    }
}
