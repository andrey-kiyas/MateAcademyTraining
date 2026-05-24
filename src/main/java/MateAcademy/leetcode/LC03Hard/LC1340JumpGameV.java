package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/jump-game-v
 */

public class LC1340JumpGameV {
    public static void main(String[] args) {
        System.out.println(maxJumps(new int[]{6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12}, 2)); // 4
        System.out.println(maxJumps(new int[]{3, 3, 3, 3, 3}, 3));                       // 1
        System.out.println(maxJumps(new int[]{7, 6, 5, 4, 3, 2, 1}, 1));                 // 7
    }

    public static int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
        int maxVisited = 0;

        for (int i = 0; i < n; i++) {
            maxVisited = Math.max(maxVisited, dfs(i, arr, d, dp));
        }

        return maxVisited;
    }

    private static int dfs(int i, int[] arr, int d, int[] dp) {
        if (dp[i] != 0) {
            return dp[i];
        }

        int n = arr.length;
        int currentMax = 1;

        for (int x = 1; x <= d && i + x < n; x++) {
            int next = i + x;
            if (arr[next] >= arr[i]) {
                break;
            }
            currentMax = Math.max(currentMax, 1 + dfs(next, arr, d, dp));
        }

        for (int x = 1; x <= d && i - x >= 0; x++) {
            int next = i - x;
            if (arr[next] >= arr[i]) {
                break;
            }
            currentMax = Math.max(currentMax, 1 + dfs(next, arr, d, dp));
        }

        dp[i] = currentMax;
        return dp[i];
    }
}
