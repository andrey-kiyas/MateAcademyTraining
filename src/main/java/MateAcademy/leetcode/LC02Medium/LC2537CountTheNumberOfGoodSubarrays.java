package MateAcademy.leetcode.LC02Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-the-number-of-good-subarrays
 */

public class LC2537CountTheNumberOfGoodSubarrays {
    public static void main(String[] args) {
        System.out.println(countGood(new int[]{1, 1, 1, 1, 1}, 10));      // Output: 1
        System.out.println(countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2)); // Output: 4
    }

    public static long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long result = 0;
        long pairs = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int count = freq.getOrDefault(nums[right], 0);
            pairs += count;
            freq.put(nums[right], count + 1);

            while (pairs >= k) {
                result += nums.length - right;
                int leftCount = freq.get(nums[left]);
                pairs -= leftCount - 1;
                freq.put(nums[left], leftCount - 1);
                left++;
            }
        }

        return result;
    }
}
