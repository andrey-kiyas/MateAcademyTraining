package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/find-the-number-of-ways-to-place-people-ii
 */

public class LC3027FindTheNumberOfWaysToPlacePeopleII {
    public static void main(String[] args) {
        int[][] points1 = {{1, 1}, {2, 2}, {3, 3}};
        int[][] points2 = {{6, 2}, {4, 4}, {2, 6}};
        int[][] points3 = {{3, 1}, {1, 3}, {1, 1}};
        System.out.println(numberOfPairs(points1)); // 0
        System.out.println(numberOfPairs(points2)); // 2
        System.out.println(numberOfPairs(points3)); // 2
    }

    public static int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int x2 = points[j][0], y2 = points[j][1];

                if (x1 <= x2 && y1 >= y2) {
                    boolean valid = true;

                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int x = points[k][0], y = points[k][1];
                        if (x1 <= x && x <= x2 && y2 <= y && y <= y1) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) count++;
                }
            }
        }
        return count;
    }
}
