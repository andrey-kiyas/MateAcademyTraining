package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/maximum-fruits-harvested-after-at-most-k-steps
 */

public class LC2106MaximumFruitsHarvestedAfterAtMostKSteps {
    public static void main(String[] args) {
        System.out.println(maxTotalFruits(new int[][]{{2, 8}, {6, 3}, {8, 6}}, 5, 4));                          // 9
        System.out.println(maxTotalFruits(new int[][]{{0, 9}, {4, 1}, {5, 7}, {6, 2}, {7, 4}, {10, 9}}, 5, 4)); // 14
        System.out.println(maxTotalFruits(new int[][]{{0, 3}, {6, 4}, {8, 5}}, 3, 2));                          // 0
    }

    public static int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int maxFruits = 0;
        int currentSum = 0;

        for (int i = 0, j = 0; j < fruits.length; ++j) {
            int positionJ = fruits[j][0];
            int fruitsAtJ = fruits[j][1];
            currentSum += fruitsAtJ;

            while (i <= j &&
                    positionJ - fruits[i][0] +
                            Math.min(Math.abs(startPos - fruits[i][0]), Math.abs(startPos - positionJ))
                            > k) {

                currentSum -= fruits[i][1];
                i++;
            }

            maxFruits = Math.max(maxFruits, currentSum);
        }
        return maxFruits;
    }
}
