package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sorted-gcd-pair-queries
 */

public class LC3312SortedGCDPairQueries {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 4};
        long[] queries1 = {0, 2, 2};
        System.out.println(Arrays.toString(gcdValues(nums1, queries1))); // [1, 2, 2]

        int[] nums2 = {4, 4, 2, 1};
        long[] queries2 = {5, 3, 1, 0};
        System.out.println(Arrays.toString(gcdValues(nums2, queries2))); // [4, 2, 1, 1]
    }

    public static int[] gcdValues(int[] nums, long[] queries) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] count = new int[maxVal + 1];
        for (int num : nums) {
            count[num]++;
        }

        long[] exactGcdCount = new long[maxVal + 1];

        for (int g = maxVal; g >= 1; g--) {
            long divisibleCount = 0;
            for (int multiple = g; multiple <= maxVal; multiple += g) {
                divisibleCount += count[multiple];
            }

            long totalPairsWithDivisor = divisibleCount * (divisibleCount - 1) / 2;

            for (int multiple = 2 * g; multiple <= maxVal; multiple += g) {
                totalPairsWithDivisor -= exactGcdCount[multiple];
            }

            exactGcdCount[g] = totalPairsWithDivisor;
        }

        long[] prefixSums = new long[maxVal + 1];
        for (int i = 1; i <= maxVal; i++) {
            prefixSums[i] = prefixSums[i - 1] + exactGcdCount[i];
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long targetIndex = queries[i];

            int low = 1, high = maxVal;
            int ansGcd = maxVal;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (prefixSums[mid] > targetIndex) {
                    ansGcd = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            answer[i] = ansGcd;
        }

        return answer;
    }
}
