package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/fruits-into-baskets-ii
 */

public class LC3477FruitsIntoBasketsII {
    public static void main(String[] args) {
        System.out.println(numOfUnplacedFruits(new int[]{4, 2, 5}, new int[]{3, 5, 4})); // 1
        System.out.println(numOfUnplacedFruits(new int[]{3, 6, 1}, new int[]{6, 4, 7})); // 0
    }

    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n];
        int result = 0;

        for (int fruit : fruits) {
            boolean placed = false;
            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruit) {
                    used[j] = true;
                    placed = true;
                    break;
                }
            }
            if (!placed) {
                result++;
            }
        }

        return result;
    }
}
