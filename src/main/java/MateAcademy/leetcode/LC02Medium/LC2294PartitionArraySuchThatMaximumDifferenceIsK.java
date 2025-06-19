package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k
 */

public class LC2294PartitionArraySuchThatMaximumDifferenceIsK {
    public static void main(String[] args) {
        System.out.println(partitionArray(new int[]{3, 6, 1, 2, 5}, 2)); // Output: 2
        System.out.println(partitionArray(new int[]{1, 2, 3}, 1));       // Output: 2
        System.out.println(partitionArray(new int[]{2, 2, 4, 5}, 0));    // Output: 3
    }

    public static int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int n = nums.length;

        while (i < n) {
            int start = nums[i];
            count++;
            while (i < n && nums[i] - start <= k) {
                i++;
            }
        }

        return count;
    }
}
