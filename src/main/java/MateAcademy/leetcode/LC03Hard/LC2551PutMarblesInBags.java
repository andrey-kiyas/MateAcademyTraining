package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/put-marbles-in-bags
 */

public class LC2551PutMarblesInBags {
    public static void main(String[] args) {
        System.out.println(putMarbles(new int[]{1, 3, 5, 1}, 2)); // Output: 4
        System.out.println(putMarbles(new int[]{1, 3}, 2));       // Output: 0
    }

    public static long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (k == 1 || n == k) return 0;

        long[] pairSums = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            pairSums[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(pairSums);

        long minSum = 0;
        long maxSum = 0;
        for (int i = 0; i < k - 1; i++) {
            minSum += pairSums[i];
            maxSum += pairSums[n - 2 - i];
        }

        return maxSum - minSum;
    }
}
