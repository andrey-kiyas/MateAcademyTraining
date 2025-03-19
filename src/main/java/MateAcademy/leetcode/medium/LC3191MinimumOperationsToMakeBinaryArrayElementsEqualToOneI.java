package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i
 */

public class LC3191MinimumOperationsToMakeBinaryArrayElementsEqualToOneI {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{0, 1, 1, 1, 0, 0})); // 3
        System.out.println(minOperations(new int[]{0, 1, 1, 1}));       // -1
    }

    public static int minOperations(int[] nums) {
        int result = 0;

        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i] == 0) {
                nums[i] ^= 1;
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                result++;
            }
        }

        for (int num : nums) {
            if (num == 0) return -1;
        }

        return result;
    }
}
