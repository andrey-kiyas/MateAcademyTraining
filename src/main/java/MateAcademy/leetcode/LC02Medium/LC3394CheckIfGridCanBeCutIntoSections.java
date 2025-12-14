package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/check-if-grid-can-be-cut-into-sections
 */

public class LC3394CheckIfGridCanBeCutIntoSections {
    public static void main(String[] args) {
        System.out.println(checkValidCuts(5,
                new int[][]{{1, 0, 5, 2}, {0, 2, 2, 4}, {3, 2, 5, 3}, {0, 4, 4, 5}}));               // true
        System.out.println(checkValidCuts(4,
                new int[][]{{0, 0, 1, 1}, {2, 0, 3, 4}, {0, 2, 2, 3}, {3, 0, 4, 3}}));               // true
        System.out.println(checkValidCuts(4,
                new int[][]{{0, 2, 2, 4}, {1, 0, 3, 2}, {2, 2, 3, 4}, {3, 0, 4, 2}, {3, 2, 4, 4}})); // false
    }

    public static boolean checkValidCuts(int n, int[][] rectangles) {
        return checkCuts(rectangles, 0) || checkCuts(rectangles, 1);
    }

    private static boolean checkCuts(int[][] rectangles, int dim) {
        int gapCount = 0;

        Arrays.sort(rectangles, Comparator.comparingInt(a -> a[dim]));

        int furthestEnd = rectangles[0][dim + 2];

        for (int i = 1; i < rectangles.length; i++) {
            int[] rect = rectangles[i];

            if (furthestEnd <= rect[dim]) {
                gapCount++;
            }

            furthestEnd = Math.max(furthestEnd, rect[dim + 2]);
        }

        return gapCount >= 2;
    }
}
