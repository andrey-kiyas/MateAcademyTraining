package MateAcademy.leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-candies-allocated-to-k-children
 */

public class LC2226MaximumCandiesAllocatedToKChildren {
    public static void main(String[] args) {
        System.out.println(maximumCandies(new int[]{5, 8, 6}, 3)); // 5
        System.out.println(maximumCandies(new int[]{2, 5}, 11));   // 0
    }

    public static int maximumCandies(int[] candies, long k) {
        int left = 0, right = Arrays.stream(candies).max().getAsInt();
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            long count = 0;
            for (int x : candies) {
                count += x / mid;
            }
            if (count >= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static int maximumCandies2(int[] candies, long k) {
        long totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }

        if (totalCandies < k) return 0;

        int low = 1, high = (int) 1e7;
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canAllocate(candies, k, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private static boolean canAllocate(int[] candies, long k, int mid) {
        long count = 0;
        for (int candy : candies) {
            count += candy / mid;
        }
        return count >= k;
    }
}
