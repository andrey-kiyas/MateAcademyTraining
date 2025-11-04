package MateAcademy.leetcode.LC01Easy;

/*
  https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC3318FindX_SumOfAllK_LongSubarraysI {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2))); // [6, 10, 12]
        System.out.println(Arrays.toString(findXSum(new int[]{3, 8, 7, 8, 7, 5}, 2, 2)));       // [11, 15, 15, 15, 12]
    }

    public static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            Map<Integer, Integer> freq = new HashMap<>();

            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            List<int[]> list = new ArrayList<>();
            for (var e : freq.entrySet()) {
                list.add(new int[]{e.getKey(), e.getValue()});
            }

            list.sort((a, b) -> {
                if (a[1] == b[1]) return b[0] - a[0];
                return b[1] - a[1];
            });

            int sum = 0;
            for (int j = 0; j < Math.min(x, list.size()); j++) {
                sum += list.get(j)[0] * list.get(j)[1];
            }

            result[i] = sum;
        }

        return result;
    }
}
