package MateAcademy.leetcode.LC02Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-erasure-value
 */

public class LC1695MaximumErasureValue {
    public static void main(String[] args) {
        System.out.println(maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));             // 17
        System.out.println(maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5})); // 8
    }

    public static int maximumUniqueSubarray(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int left = 0, right = 0, maxSum = 0, currentSum = 0;

        while (right < nums.length) {
            if (!seen.contains(nums[right])) {
                seen.add(nums[right]);
                currentSum += nums[right];
                maxSum = Math.max(maxSum, currentSum);
                right++;
            } else {
                seen.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }
        }

        return maxSum;
    }
}
