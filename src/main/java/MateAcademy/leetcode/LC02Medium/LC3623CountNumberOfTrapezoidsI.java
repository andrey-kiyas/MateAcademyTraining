package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-number-of-trapezoids-i
 */

public class LC3623CountNumberOfTrapezoidsI {
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(countTrapezoids(new int[][]{
                {1, 0}, {2, 0}, {3, 0}, {2, 2}, {3, 2}
        })); // 3

        System.out.println(countTrapezoids(new int[][]{
                {0, 0}, {1, 0}, {0, 1}, {2, 1}
        })); // 1
    }

    public static int countTrapezoids(int[][] points) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int[] p : points) {
            freq.put(p[1], freq.getOrDefault(p[1], 0) + 1);
        }

        List<Long> combos = new ArrayList<>();

        for (int c : freq.values()) {
            if (c >= 2) {
                long ways = (long)c * (c - 1) / 2;
                combos.add(ways % MOD);
            }
        }

        if (combos.size() < 2) return 0;

        long answer = 0;
        long suffixSum = 0;

        for (int i = combos.size() - 1; i >= 0; i--) {
            answer = (answer + combos.get(i) * suffixSum) % MOD;
            suffixSum = (suffixSum + combos.get(i)) % MOD;
        }

        return (int) answer;
    }
}
