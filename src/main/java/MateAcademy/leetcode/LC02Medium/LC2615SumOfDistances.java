package MateAcademy.leetcode.LC02Medium;

/*
 * https://leetcode.com/problems/sum-of-distances
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC2615SumOfDistances {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(distance(new int[]{1, 3, 1, 1, 2}))); // [5, 0, 3, 4, 0]
        System.out.println(Arrays.toString(distance(new int[]{0, 5, 3})));       // [0, 0, 0]
    }

    public static long[] distance(int[] nums) {
        int n = nums.length;
        long[] result = new long[n];

        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> indices : indexMap.values()) {
            int k = indices.size();
            if (k <= 1) continue;

            long totalSum = 0;
            for (int idx : indices) {
                totalSum += idx;
            }

            long prefixSum = 0;
            for (int i = 0; i < k; i++) {
                long currentIdx = indices.get(i);

                long leftSum = i * currentIdx - prefixSum;

                long suffixSum = totalSum - prefixSum - currentIdx;
                long rightSum = suffixSum - (k - 1 - i) * currentIdx;

                result[(int) currentIdx] = leftSum + rightSum;

                prefixSum += currentIdx;
            }
        }

        return result;
    }
}
