package MateAcademy.leetcode.LC02Medium;

import java.util.List;

/**
 * https://leetcode.com/problems/triangle
 */

public class LC0120Triangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle1 = List.of(
                List.of(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
        );
        System.out.println(minimumTotal(triangle1)); // 11

        List<List<Integer>> triangle2 = List.of(
                List.of(-10)
        );
        System.out.println(minimumTotal(triangle2)); // -10
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];

        for (int j = 0; j < n; j++) {
            dp[j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }

        return dp[0];
    }
}
