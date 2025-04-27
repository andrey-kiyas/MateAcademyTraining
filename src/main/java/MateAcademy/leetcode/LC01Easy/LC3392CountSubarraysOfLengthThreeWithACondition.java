package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition
 */

public class LC3392CountSubarraysOfLengthThreeWithACondition {
    public static void main(String[] args) {
        System.out.println(countSubarrays(new int[]{1, 2, 1, 4, 1})); // 1
        System.out.println(countSubarrays(new int[]{1, 1, 1}));       // 0
        System.out.println(countSubarrays(new int[]{-1, -4, -1, 4})); // 1
    }

    public static int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 0; i <= nums.length - 3; i++) {
            int first = nums[i];
            int middle = nums[i + 1];
            int third = nums[i + 2];
            // Приводимо до double і ділимо
            if (first + third == middle / 2.0) {
                count++;
            }
        }
        return count;
    }
}
