package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array
 */

public class LC2176CountEqualAndDivisiblePairsInAnArray {

    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{3, 1, 2, 2, 2, 1, 3}, 2));
        System.out.println(countPairs(new int[]{1, 2, 3, 4}, 1));
    }

    public static int countPairs(int[] nums, int k) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
