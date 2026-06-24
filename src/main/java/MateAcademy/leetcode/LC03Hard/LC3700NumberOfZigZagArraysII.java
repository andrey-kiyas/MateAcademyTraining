package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-zigzag-arrays-ii
 */

public class LC3700NumberOfZigZagArraysII {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(zigZagArrays(3, 4, 5)); // 2
        System.out.println(zigZagArrays(3, 1, 3)); // 10
    }

    public static int zigZagArrays(int n, int l, int r) {
        int M = r - l + 1;
        int size = 2 * M;

        long[][] T = new long[size][size];

        for (int j = 0; j < M; j++) {
            for (int k = 0; k < j; k++) {
                T[j][M + k] = 1;
            }
            for (int k = j + 1; k < M; k++) {
                T[M + j][k] = 1;
            }
        }

        long[][] T_pow = matrixPower(T, n - 1);

        long[] V1 = new long[size];
        Arrays.fill(V1, 1);

        long totalWays = 0;
        for (int i = 0; i < size; i++) {
            long currentTerm = 0;
            for (int j = 0; j < size; j++) {
                currentTerm = (currentTerm + T_pow[i][j] * V1[j]) % MOD;
            }
            totalWays = (totalWays + currentTerm) % MOD;
        }

        return (int) totalWays;
    }

    private static long[][] matrixPower(long[][] base, int p) {
        int size = base.length;
        long[][] res = new long[size][size];

        for (int i = 0; i < size; i++) {
            res[i][i] = 1;
        }

        long[][] curr = base;
        while (p > 0) {
            if ((p & 1) == 1) {
                res = multiplyMatrices(res, curr);
            }
            curr = multiplyMatrices(curr, curr);
            p >>= 1;
        }
        return res;
    }

    private static long[][] multiplyMatrices(long[][] A, long[][] B) {
        int size = A.length;
        long[][] C = new long[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < size; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }
}
