package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-array-according-to-given-pivot
 */

public class LC2161PartitionArrayAccordingToGivenPivot {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                pivotArray(new int[]{9, 12, 5, 10, 14, 3, 10}, 10))); // [9, 5, 3, 10, 10, 12, 14]
        System.out.println(Arrays.toString(
                pivotArray(new int[]{-3, 4, 3, 2}, 2)));              // [-3, 2, 4, 3]

    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int[nums.length];
        int index = 0;

        for (int num : nums) {
            if (num < pivot) {
                result[index++] = num;
            }
        }

        for (int num : nums) {
            if (num == pivot) {
                result[index++] = num;
            }
        }

        for (int num : nums) {
            if (num > pivot) {
                result[index++] = num;
            }
        }

        return result;
    }
}
