package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/minimum-time-to-make-rope-colorful
 */

public class LC1578MinimumTimeToMakeRopeColorful {
    public static void main(String[] args) {
        System.out.println(minCost("abaac", new int[]{1, 2, 3, 4, 5})); // 3
        System.out.println(minCost("abc", new int[]{1, 2, 3}));         // 0
        System.out.println(minCost("aabaa", new int[]{1, 2, 3, 4, 1})); // 2
    }

    public static int minCost(String colors, int[] neededTime) {
        int result = 0;
        int n = colors.length();

        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                result += Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }
        return result;
    }
}
