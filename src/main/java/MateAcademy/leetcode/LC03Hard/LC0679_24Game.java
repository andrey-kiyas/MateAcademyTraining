package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/24-game
 */

public class LC0679_24Game {
    public static void main(String[] args) {
        System.out.println(judgePoint24(new int[]{4, 1, 8, 7})); // true
        System.out.println(judgePoint24(new int[]{1, 2, 1, 2})); // false
    }

    public static boolean judgePoint24(int[] cards) {
        List<Double> doubleNums = new ArrayList<>();

        for (final int num : cards)
            doubleNums.add((double) num);

        return dfs(doubleNums);
    }

    private static boolean dfs(List<Double> nums) {
        if (nums.size() == 1)
            return Math.abs(nums.get(0) - 24.0) < 0.001;

        for (int i = 0; i < nums.size(); ++i)
            for (int j = i + 1; j < nums.size(); ++j)
                for (final double num : generate(nums.get(i), nums.get(j))) {
                    List<Double> nextRound = new ArrayList<>(List.of(num));
                    for (int k = 0; k < nums.size(); ++k) {
                        if (k == i || k == j)
                            continue;
                        nextRound.add(nums.get(k));
                    }
                    if (dfs(nextRound))
                        return true;
                }

        return false;
    }

    private static double[] generate(double a, double b) {
        return new double[] {a * b, a / b, b / a, a + b, a - b, b - a};
    }
}
