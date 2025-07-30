package MateAcademy.leetcode.LC01Easy;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values
 */

public class LC2570MergeTwo2DArraysBySummingValues {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(mergeArrays(
                new int[][]{{1, 2}, {2, 3}, {4, 5}},
                new int[][]{{1, 4}, {3, 2}, {4, 1}})));     // [[1, 4], [2, 6], [4, 10]]
        System.out.println(Arrays.deepToString(mergeArrays(
                new int[][]{{2, 4}, {3, 6}, {5, 5}},
                new int[][]{{1, 3}, {4, 3}})));             // [[1, 3], [2, 4], [3, 6], [4, 3], [5, 5]]
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int[] pair : nums1) {
            map.put(pair[0], map.getOrDefault(pair[0], 0) + pair[1]);
        }

        for (int[] pair : nums2) {
            map.put(pair[0], map.getOrDefault(pair[0], 0) + pair[1]);
        }

        int[][] result = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[index++] = new int[]{entry.getKey(), entry.getValue()};
        }

        return result;
    }
}
