package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-zigzag-arrays-i
 */

public class LC3699NumberOfZigZagArraysI {
    public static void main(String[] args) {
        System.out.println(zigZagArrays(3, 4, 5)); // 2
        System.out.println(zigZagArrays(3, 1, 3)); // 10
    }

    public static int zigZagArrays(int n, int l, int r) {
        int M = r - l + 1;
        long MOD = 1_000_000_007;

        long[] up = new long[M];
        long[] down = new long[M];
        Arrays.fill(up, 1);
        Arrays.fill(down, 1);

        for (int i = 2; i <= n; i++) {
            long[] nextUp = new long[M];
            long[] nextDown = new long[M];

            long[] prefDown = new long[M];
            prefDown[0] = down[0];
            for (int j = 1; j < M; j++) {
                prefDown[j] = (prefDown[j - 1] + down[j]) % MOD;
            }

            long[] suffUp = new long[M];
            suffUp[M - 1] = up[M - 1];
            for (int j = M - 2; j >= 0; j--) {
                suffUp[j] = (suffUp[j + 1] + up[j]) % MOD;
            }

            for (int j = 0; j < M; j++) {
                if (j > 0) {
                    nextUp[j] = prefDown[j - 1];
                }
                if (j < M - 1) {
                    nextDown[j] = suffUp[j + 1];
                }
            }

            up = nextUp;
            down = nextDown;
        }

        long totalWays = 0;
        for (int j = 0; j < M; j++) {
            totalWays = (totalWays + up[j] + down[j]) % MOD;
        }

        return (int) (totalWays % MOD);
    }
}
