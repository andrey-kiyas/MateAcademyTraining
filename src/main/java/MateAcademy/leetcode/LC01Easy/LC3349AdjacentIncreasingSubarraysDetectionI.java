package MateAcademy.leetcode.LC01Easy;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i
 */

public class LC3349AdjacentIncreasingSubarraysDetectionI {
    public static void main(String[] args) {
        List<Integer> nums1 = Arrays.asList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1);
        int k1 = 3;
        System.out.println("Результат: " + hasIncreasingSubarrays(nums1, k1) + " (Ожидается: true)");

        List<Integer> nums2 = Arrays.asList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7);
        int k2 = 5;
        System.out.println("Результат: " + hasIncreasingSubarrays(nums2, k2) + " (Ожидается: false)");

        List<Integer> nums3 = Arrays.asList(1, 2, 3, 1, 2, 3, 1, 2, 3);
        int k3 = 4; // 2k = 8
        System.out.println("Результат: " + hasIncreasingSubarrays(nums3, k3) + " (Ожидается: false)");
    }

    public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int requiredLength = 2 * k;

        int maxStartIndex = nums.size() - requiredLength;

        for (int a = 0; a <= maxStartIndex; a++) {
            int b = a + k;

            boolean firstSubarrayIsIncreasing = isStrictlyIncreasing(nums, a, k);

            if (firstSubarrayIsIncreasing) {
                boolean secondSubarrayIsIncreasing = isStrictlyIncreasing(nums, b, k);

                if (secondSubarrayIsIncreasing) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isStrictlyIncreasing(List<Integer> nums, int start, int k) {
        int end = start + k - 1;

        for (int i = start; i < end; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
