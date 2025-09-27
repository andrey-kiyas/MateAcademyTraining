package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/largest-triangle-area
 */

public class LC0812LargestTriangleArea {
    public static void main(String[] args) {
        System.out.println(largestTriangleArea(new int[][]{
                {0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}
        })); // 2.0

        System.out.println(largestTriangleArea(new int[][]{
                {1, 0}, {0, 0}, {0, 1}
        })); // 0.5
    }

    public static double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double area = Math.abs(
                            points[i][0] * (points[j][1] - points[k][1]) +
                                    points[j][0] * (points[k][1] - points[i][1]) +
                                    points[k][0] * (points[i][1] - points[j][1])
                    ) / 2.0;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}
