package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/number-of-zero-filled-subarrays
 */

public class LC2348NumberOfZeroFilledSubarrays {
    public static void main(String[] args) {
        System.out.println(zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4})); // 6
        System.out.println(zeroFilledSubarray(new int[]{0, 0, 0, 2, 0, 0}));       // 9
        System.out.println(zeroFilledSubarray(new int[]{2, 10, 2019}));            // 0
    }

    public static long zeroFilledSubarray(int[] nums) {
        long result = 0;
        long count = 0;

        for (int num : nums) {
            if (num == 0) {
                count++;
                result += count;
            } else {
                count = 0;
            }
        }
        return result;
    }
}
