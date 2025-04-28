package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/count-subarrays-with-score-less-than-k
 */

public class LC2302CountSubarraysWithScoreLessThanK {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{2, 1, 4, 3, 5}, 10)); // Output: 6
        System.out.println(countSubarrays(new int[]{1, 1, 1}, 5));        // Output: 5
    }

    public static long countSubarrays(int[] nums, long k) {
        long res = 0;
        long sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum * (right - left + 1) >= k) {
                sum -= nums[left];
                left++;
            }

            res += (right - left + 1);
        }

        return res;
    }
}
