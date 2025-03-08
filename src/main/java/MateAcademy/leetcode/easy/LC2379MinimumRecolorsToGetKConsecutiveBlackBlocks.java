package MateAcademy.leetcode.easy;

/**
 * https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks
 */

public class LC2379MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public static void main(String[] args) {
        System.out.println(minimumRecolors("WBBWWBBWBW", 7)); // 3
        System.out.println(minimumRecolors("WBWBBBW", 2));    // 0
    }

    public static int minimumRecolors(String blocks, int k) {
        int minOperations = Integer.MAX_VALUE;

        for (int i = 0; i <= blocks.length() - k; i++) {
            int whiteCount = 0;
            for (int j = i; j < i + k; j++) {
                if (blocks.charAt(j) == 'W') {
                    whiteCount++;
                }
            }
            minOperations = Math.min(minOperations, whiteCount);
        }

        return minOperations;
    }
}
