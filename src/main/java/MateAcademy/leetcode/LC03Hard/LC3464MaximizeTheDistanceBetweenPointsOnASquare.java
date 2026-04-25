package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximize-the-distance-between-points-on-a-square
 */

public class LC3464MaximizeTheDistanceBetweenPointsOnASquare {
    public static void main(String[] args) {
        System.out.println(maxDistance(2, new int[][]{{0, 2}, {2, 0}, {2, 2}, {0, 0}}, 4));                         // 2
        System.out.println(maxDistance(2, new int[][]{{0, 0}, {1, 2}, {2, 0}, {2, 2}, {2, 1}}, 4));                 // 1
        System.out.println(maxDistance(2, new int[][]{{0, 0}, {0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 2}, {2, 1}}, 5)); // 1
    }

    public static int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] pos = new long[n];

        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (y == 0) pos[i] = x;
            else if (x == side) pos[i] = (long) side + y;
            else if (y == side) pos[i] = (long) 2 * side + (side - x);
            else pos[i] = (long) 3 * side + (side - y);
        }

        Arrays.sort(pos);

        int low = 1, high = side;
        int result = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(pos, k, mid, (long) 4 * side)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    private static boolean canPlace(long[] pos, int k, int dist, long totalLen) {
        int n = pos.length;
        for (int i = 0; i < n && pos[i] < pos[0] + dist; i++) {
            int count = 1;
            long lastPos = pos[i];
            long firstPos = pos[i];

            for (int j = i + 1; j < n; j++) {
                if (pos[j] - lastPos >= dist) {
                    lastPos = pos[j];
                    count++;
                    if (count == k) break;
                }
            }

            if (count == k && (totalLen - (lastPos - firstPos)) >= dist) {
                return true;
            }
        }
        return false;
    }
}
