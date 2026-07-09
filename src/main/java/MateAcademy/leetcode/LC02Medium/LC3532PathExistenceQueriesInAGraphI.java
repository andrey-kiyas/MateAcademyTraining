package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/path-existence-queries-in-a-graph-i
 */

public class LC3532PathExistenceQueriesInAGraphI {
    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[][] q1 = {{0, 0}, {0, 1}};
        System.out.println(Arrays.toString(pathExistenceQueries(2, nums1, 1, q1)));
        // [true, false]

        int[] nums2 = {2, 5, 6, 8};
        int[][] q2 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        System.out.println(Arrays.toString(pathExistenceQueries(4, nums2, 2, q2)));
        // [false, false, true, true]
    }

    public static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];
        int currentId = 0;
        component[0] = currentId;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                currentId++;
            }
            component[i] = currentId;
        }

        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            answer[i] = (component[u] == component[v]);
        }

        return answer;
    }
}
