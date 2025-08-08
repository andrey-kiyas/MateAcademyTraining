package MateAcademy.leetcode.LC01Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/soup-servings
 */

public class LC0808SoupServings {
    private static final int[][] SERVES = {
            {4, 0},
            {3, 1},
            {2, 2},
            {1, 3}
    };
    private static Map<String, Double> memo;

    public static void main(String[] args) {
        System.out.println(soupServings(50));   // 0.62500
        System.out.println(soupServings(100));  // 0.71875
    }

    public static double soupServings(int n) {

        if (n > 5000) {
            return 1.0;
        }
        int units = (int) Math.ceil(n / 25.0);
        memo = new HashMap<>();
        return dfs(units, units);
    }

    private static double dfs(int a, int b) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        String key = a + "," + b;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        double prob = 0.0;
        for (int[] s : SERVES) {
            prob += dfs(a - s[0], b - s[1]);
        }
        prob *= 0.25;

        memo.put(key, prob);
        return prob;
    }
}
