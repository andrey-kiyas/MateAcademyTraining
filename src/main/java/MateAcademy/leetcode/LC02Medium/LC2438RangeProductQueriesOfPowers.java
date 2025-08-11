package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/range-product-queries-of-powers
 */

public class LC2438RangeProductQueriesOfPowers {

    public static void main(String[] args) {
        int n1 = 15;
        int[][] q1 = {{0, 1}, {2, 2}, {0, 3}};
        System.out.println(Arrays.toString(productQueries(n1, q1))); // [2, 4, 64]

        int n2 = 2;
        int[][] q2 = {{0, 0}};
        System.out.println(Arrays.toString(productQueries(n2, q2))); // [2]
    }

    public static int[] productQueries(int n, int[][] queries) {
        int[] powers = new int[Integer.bitCount(n)];
        for (int i = 0; n > 0; ++i) {
            int x = n & -n;
            powers[i] = x;
            n -= x;
        }
        int m = queries.length;
        int[] result = new int[m];
        final int mod = (int) 1e9 + 7;
        for (int i = 0; i < m; ++i) {
            int l = queries[i][0], r = queries[i][1];
            long x = 1;
            for (int j = l; j <= r; ++j) {
                x = x * powers[j] % mod;
            }
            result[i] = (int) x;
        }
        return result;
    }
}
