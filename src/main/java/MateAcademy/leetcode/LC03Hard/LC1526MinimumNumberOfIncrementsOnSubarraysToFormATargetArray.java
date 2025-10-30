package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array
 */

public class LC1526MinimumNumberOfIncrementsOnSubarraysToFormATargetArray {
    public static void main(String[] args) {
        System.out.println(minNumberOperations(new int[]{1, 2, 3, 2, 1})); // 3
        System.out.println(minNumberOperations(new int[]{3, 1, 1, 2}));    // 4
        System.out.println(minNumberOperations(new int[]{3, 1, 5, 4, 2})); // 7
    }

    public static int minNumberOperations(int[] target) {
        int result = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                result += target[i] - target[i - 1];
            }
        }
        return result;
    }
}
