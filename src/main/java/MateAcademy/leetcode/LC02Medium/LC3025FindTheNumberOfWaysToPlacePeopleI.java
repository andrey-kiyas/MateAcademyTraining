package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-number-of-ways-to-place-people-i
 */

public class LC3025FindTheNumberOfWaysToPlacePeopleI {
    public static void main(String[] args) {
        int[][] points1 = {{1, 1}, {2, 2}, {3, 3}};
        int[][] points2 = {{6, 2}, {4, 4}, {2, 6}};
        int[][] points3 = {{3, 1}, {1, 3}, {1, 1}};

        System.out.println(numberOfPairs(points1)); // 0
        System.out.println(numberOfPairs(points2)); // 2
        System.out.println(numberOfPairs(points3)); // 2
    }

    public static int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int result = 0;
        int n = points.length;
        final int inf = 1 << 30;
        for (int i = 0; i < n; ++i) {
            int y1 = points[i][1];
            int maxY = -inf;
            for (int j = i + 1; j < n; ++j) {
                int y2 = points[j][1];
                if (maxY < y2 && y2 <= y1) {
                    maxY = y2;
                    ++result;
                }
            }
        }
        return result;
    }
}
