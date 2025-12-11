package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-covered-buildings
 */

public class LC3531CountCoveredBuildings {
    public static void main(String[] args) {
        System.out.println(countCoveredBuildings(3, new int[][]{
                {1, 2}, {2, 2}, {3, 2}, {2, 1}, {2, 3}
        })); // 1

        System.out.println(countCoveredBuildings(3, new int[][]{
                {1, 1}, {1, 2}, {2, 1}, {2, 2}
        })); // 0

        System.out.println(countCoveredBuildings(5, new int[][]{
                {1, 3}, {3, 2}, {3, 3}, {3, 5}, {5, 3}
        })); // 1
    }

    public static int countCoveredBuildings(int n, int[][] buildings) {
        int m = buildings.length;

        int[] minY = new int[n + 1];
        int[] maxY = new int[n + 1];
        int[] minX = new int[n + 1];
        int[] maxX = new int[n + 1];

        Arrays.fill(minY, Integer.MAX_VALUE);
        Arrays.fill(minX, Integer.MAX_VALUE);
        Arrays.fill(maxY, Integer.MIN_VALUE);
        Arrays.fill(maxX, Integer.MIN_VALUE);

        for (int[] b : buildings) {
            int x = b[0], y = b[1];
            minY[x] = Math.min(minY[x], y);
            maxY[x] = Math.max(maxY[x], y);
            minX[y] = Math.min(minX[y], x);
            maxX[y] = Math.max(maxX[y], x);
        }

        int count = 0;

        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            boolean hasLeft  = (y > minY[x]);
            boolean hasRight = (y < maxY[x]);
            boolean hasUp    = (x > minX[y]);
            boolean hasDown  = (x < maxX[y]);

            if (hasLeft && hasRight && hasUp && hasDown) {
                count++;
            }
        }

        return count;
    }
}
