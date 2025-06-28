package MateAcademy.leetcode.LC01Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum
 */

public class LC2099FindSubsequenceOfLengthKWithTheLargestSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSubsequence(new int[]{2, 1, 3, 3}, 2)));   // [3, 3]
        System.out.println(Arrays.toString(maxSubsequence(new int[]{-1, -2, 3, 4}, 3))); // [-1, 3, 4]
        System.out.println(Arrays.toString(maxSubsequence(new int[]{3, 4, 3, 3}, 2)));   // [4, 3] or [3, 4]
    }

    public static int[] maxSubsequence(int[] nums, int k) {
        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            pairs.add(new int[]{nums[i], i});
        }

        pairs.sort((a, b) -> Integer.compare(b[0], a[0]));

        List<int[]> topK = pairs.subList(0, k);

        topK.sort(Comparator.comparingInt(a -> a[1]));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.get(i)[0];
        }

        return result;
    }
}
