package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/count-subarrays-with-majority-element-i
 */

public class LC3737CountSubarraysWithMajorityElementI {
    public static void main(String[] args) {
        System.out.println(countMajoritySubarrays(new int[]{1, 2, 2, 3}, 2)); // 5
        System.out.println(countMajoritySubarrays(new int[]{1, 1, 1, 1}, 1)); // 10
        System.out.println(countMajoritySubarrays(new int[]{1, 2, 3}, 4));    // 0
    }

    public static int countMajoritySubarrays(int[] nums, int target) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int balance = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] == target) {
                    balance++;
                } else {
                    balance--;
                }

                if (balance > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
