package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/minimum-operations-to-make-array-elements-zero
 */

public class LC3495MinimumOperationsToMakeArrayElementsZero {
    public static void main(String[] args) {
        int[][] q1 = {{1, 2}, {2, 4}};
        System.out.println(minOperations(q1)); // 3

        int[][] q2 = {{2, 6}};
        System.out.println(minOperations(q2)); // 4
    }

    public static long minOperations(int[][] queries) {
        long total = 0;
        for (int[] q : queries) {
            long sumSteps = prefixSteps(q[1]) - prefixSteps(q[0] - 1);
            total += (sumSteps + 1) / 2;
        }
        return total;
    }

    private static long prefixSteps(long n) {
        if (n <= 0) return 0;
        long sum = 0;
        long power = 1;
        int step = 1;

        while (power <= n) {
            long next = power * 4 - 1;
            long end = Math.min(n, next);
            long count = end - power + 1;
            sum += count * step;

            power *= 4;
            step++;
        }

        return sum;
    }
}
