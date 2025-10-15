package MateAcademy.leetcode.LC02Medium;

import java.util.List;

/**
 * https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii
 */

public class LC3350AdjacentIncreasingSubarraysDetectionII {
    public static void main(String[] args) {
        System.out.println(maxIncreasingSubarrays(List.of(2, 5, 7, 8, 9, 2, 3, 4, 3, 1))); // 3
        System.out.println(maxIncreasingSubarrays(List.of(1, 2, 3, 4, 4, 4, 4, 5, 6, 7))); // 2
    }

    public static int maxIncreasingSubarrays(List<Integer> nums) {
        int result = 0;
        int previousLength = 0;
        int currentLength = 0;
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            currentLength++;

            if (i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                result = Math.max(result,
                        Math.max(currentLength / 2,
                                Math.min(previousLength, currentLength)));

                previousLength = currentLength;

                currentLength = 0;
            }
        }

        return result;
    }
}
