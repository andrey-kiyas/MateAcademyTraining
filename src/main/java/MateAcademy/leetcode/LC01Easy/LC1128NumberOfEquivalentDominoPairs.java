package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/number-of-equivalent-domino-pairs
 */

public class LC1128NumberOfEquivalentDominoPairs {
    public static void main(String[] args) {
        System.out.println(numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {3, 4}, {5, 6}}));         // 1
        System.out.println(numEquivDominoPairs(new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {2, 2}})); // 3
    }

    public static int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int result = 0;

        for (int[] d : dominoes) {
            int a = Math.min(d[0], d[1]);
            int b = Math.max(d[0], d[1]);
            int key = a * 10 + b;

            result += count[key];
            count[key]++;
        }

        return result;
    }
}
