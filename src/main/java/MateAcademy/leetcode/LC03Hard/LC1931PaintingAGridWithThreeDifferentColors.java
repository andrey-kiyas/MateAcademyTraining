package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/painting-a-grid-with-three-different-colors
 */

public class LC1931PaintingAGridWithThreeDifferentColors {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(colorTheGrid(1, 1)); // 3
        System.out.println(colorTheGrid(1, 2)); // 6
        System.out.println(colorTheGrid(5, 5)); // 580986
    }

    public static int colorTheGrid(int m, int n) {
        List<int[]> states = new ArrayList<>();
        generateStates(m, new int[m], 0, states);

        Map<String, List<int[]>> transitions = new HashMap<>();
        for (int[] prev : states) {
            String key = Arrays.toString(prev);
            transitions.putIfAbsent(key, new ArrayList<>());
            for (int[] curr : states) {
                if (compatible(prev, curr))
                    transitions.get(key).add(curr);
            }
        }

        Map<String, Integer> dp = new HashMap<>();
        for (int[] state : states) {
            dp.put(Arrays.toString(state), 1);
        }

        for (int i = 1; i < n; i++) {
            Map<String, Integer> newDp = new HashMap<>();
            for (int[] prev : states) {
                String prevKey = Arrays.toString(prev);
                int count = dp.get(prevKey);

                for (int[] curr : transitions.get(prevKey)) {
                    String currKey = Arrays.toString(curr);
                    newDp.put(currKey, (newDp.getOrDefault(currKey, 0) + count) % MOD);
                }
            }
            dp = newDp;
        }

        int result = 0;
        for (int val : dp.values()) {
            result = (result + val) % MOD;
        }
        return result;
    }

    private static void generateStates(int m, int[] curr, int pos, List<int[]> result) {
        if (pos == m) {
            result.add(curr.clone());
            return;
        }
        for (int color = 0; color < 3; color++) {
            if (pos > 0 && curr[pos - 1] == color) continue;
            curr[pos] = color;
            generateStates(m, curr, pos + 1, result);
        }
    }

    private static boolean compatible(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) return false;
        }
        return true;
    }
}
