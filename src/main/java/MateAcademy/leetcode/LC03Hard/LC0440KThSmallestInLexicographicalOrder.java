package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/k-th-smallest-in-lexicographical-order
 */

public class LC0440KThSmallestInLexicographicalOrder {
    public static void main(String[] args) {
        System.out.println(findKthNumber(13, 2)); // Output: 10
        System.out.println(findKthNumber(1, 1));  // Output: 1
    }

    public static int findKthNumber(int n, int k) {
        int current = 1;
        k--; // because we start from 1

        while (k > 0) {
            long steps = countSteps(n, current, current + 1);
            if (steps <= k) {
                // Skip this subtree
                current++;
                k -= steps;
            } else {
                // Go deeper
                current *= 10;
                k--;
            }
        }

        return current;
    }

    private static long countSteps(int n, long prefix, long nextPrefix) {
        long steps = 0;
        while (prefix <= n) {
            steps += Math.min(n + 1, nextPrefix) - prefix;
            prefix *= 10;
            nextPrefix *= 10;
        }
        return steps;
    }
}
