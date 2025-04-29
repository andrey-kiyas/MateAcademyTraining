package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times
 */

public class LC2962CountSubarraysWhereMaxElementAppearsAtLeastKTimes {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 3, 2, 3, 3}, 2)); // 6
        System.out.println(countSubarrays(new int[]{1, 4, 2, 1}, 3));    // 0
    }

    public static long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        long result = 0;
        int left = 0, countMax = 0;

        for (int right = 0; right < n; right++) {
            if (nums[right] == maxVal) countMax++;

            while (countMax >= k) {
                result += (n - right);
                if (nums[left] == maxVal) countMax--;
                left++;
            }
        }

        return result;
    }
}
