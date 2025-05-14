package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/total-characters-in-string-after-transformations-ii
 */

public class LC3337TotalCharactersInStringAfterTransformationsII {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(lengthAfterTransformations(
                "abcyy",
                2,
                Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2)
        )); // 7

        System.out.println(lengthAfterTransformations(
                "azbk",
                1,
                Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2)
        )); // 8
    }

    public static int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[][] T = getTransformationMatrix(nums);
        int[][] poweredT = matrixPow(T, t);
        int[] count = new int[26];
        long[] lengths = new long[26];

        for (final char c : s.toCharArray())
            ++count[c - 'a'];

        for (int i = 0; i < 26; ++i)
            for (int j = 0; j < 26; ++j) {
                lengths[j] += (long) count[i] * poweredT[i][j];
                lengths[j] %= MOD;
            }

        return (int) (Arrays.stream(lengths).sum() % MOD);
    }

    private static int[][] getTransformationMatrix(List<Integer> nums) {
        int[][] T = new int[26][26];
        for (int i = 0; i < nums.size(); ++i)
            for (int step = 1; step <= nums.get(i); ++step)
                ++T[i][(i + step) % 26];
        return T;
    }

    private static int[][] getIdentityMatrix(int sz) {
        int[][] I = new int[sz][sz];
        for (int i = 0; i < sz; ++i)
            I[i][i] = 1;
        return I;
    }

    private static int[][] matrixMult(int[][] A, int[][] B) {
        final int sz = A.length;
        int[][] C = new int[sz][sz];
        for (int i = 0; i < sz; ++i)
            for (int j = 0; j < sz; ++j)
                for (int k = 0; k < sz; ++k)
                    C[i][j] = (int) ((C[i][j] + (long) A[i][k] * B[k][j]) % MOD);
        return C;
    }

    private static int[][] matrixPow(int[][] M, int n) {
        if (n == 0)
            return getIdentityMatrix(M.length);
        if (n % 2 == 1)
            return matrixMult(M, matrixPow(M, n - 1));
        return matrixPow(matrixMult(M, M), n / 2);
    }
}
