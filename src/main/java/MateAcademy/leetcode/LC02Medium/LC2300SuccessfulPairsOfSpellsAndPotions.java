package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/successful-pairs-of-spells-and-potions
 */

public class LC2300SuccessfulPairsOfSpellsAndPotions {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(successfulPairs(
                new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7))); // [4, 0, 3]

        System.out.println(Arrays.toString(successfulPairs(
                new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16)));      // [2, 0, 2]
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            long spell = spells[i];
            long need = (success + spell - 1) / spell;

            int index = binarySearch(potions, need);

            res[i] = m - index;
        }

        return res;
    }

    private static int binarySearch(int[] potions, long need) {
        int left = 0, right = potions.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] < need) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
