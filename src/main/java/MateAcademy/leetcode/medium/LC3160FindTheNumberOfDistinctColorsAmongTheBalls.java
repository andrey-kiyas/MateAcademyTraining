package MateAcademy.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls
 */

public class LC3160FindTheNumberOfDistinctColorsAmongTheBalls {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(queryResults(4, new int[][]{{1, 4}, {2, 5}, {1, 3}, {3, 4}})));
        System.out.println(Arrays.toString(queryResults(4, new int[][]{{1, 4}, {2, 5}, {1, 3}, {3, 4}})));
    }

    public static int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> ballToColor = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];

            if (ballToColor.containsKey(ball)) {
                int oldColor = ballToColor.get(ball);

                colorCount.put(oldColor, colorCount.get(oldColor) - 1);
                if (colorCount.get(oldColor) == 0) {
                    colorCount.remove(oldColor);
                }
            }

            ballToColor.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            result[i] = colorCount.size();
        }
        return result;
    }
}
