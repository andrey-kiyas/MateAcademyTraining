package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals
 */

public class LC1863SumOfAllSubsetXORTotals {
    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{1, 3}));             // 6
        System.out.println(subsetXORSum(new int[]{5, 1, 6}));          // 28
        System.out.println(subsetXORSum(new int[]{3, 4, 5, 6, 7, 8})); // 480
    }

    public static int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private static int dfs(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR;
        }

        int with = dfs(nums, index + 1, currentXOR ^ nums[index]);

        int without = dfs(nums, index + 1, currentXOR);

        return with + without;
    }
}
