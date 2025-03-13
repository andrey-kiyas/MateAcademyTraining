package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/zero-array-transformation-ii
 */

public class LC3356ZeroArrayTransformationII {
    public static void main(String[] args) {
        System.out.println(minZeroArray(
                new int[]{2, 0, 2},
                new int[][]{{0, 2, 1}, {0, 2, 1}, {1, 1, 3}})); // 2
        System.out.println(minZeroArray(
                new int[]{4, 3, 2, 1},
                new int[][]{{1, 3, 2}, {0, 2, 1}}));            // -1
    }

    public static int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int sum = 0;
        int pos = 0;

        for (int i = 0; i < n; ++i) {
            while (sum + diff[i] < nums[i]) {
                if (pos == queries.length)
                    return -1;

                int start = queries[pos][0];
                int end = queries[pos][1];
                int val = queries[pos][2];
                pos++;

                if (end < i) continue;

                diff[Math.max(start, i)] += val;
                if (end + 1 < n) diff[end + 1] -= val;
            }
            sum += diff[i];
        }
        return pos;
    }
}
