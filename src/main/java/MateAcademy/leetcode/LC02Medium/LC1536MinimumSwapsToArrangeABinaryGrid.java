package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid
 */

public class LC1536MinimumSwapsToArrangeABinaryGrid {
    public static void main(String[] args) {
        System.out.println(minSwaps(new int[][]{{0, 0, 1}, {1, 1, 0}, {1, 0, 0}}));                        // 3
        System.out.println(minSwaps(new int[][]{{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}, {0, 1, 1, 0}})); // -1
    }

    public static int minSwaps(int[][] grid) {
        int n = grid.length;
        List<Integer> trailingZeros = new ArrayList<>();

        for (int[] ints : grid) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (ints[j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            trailingZeros.add(count);
        }

        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int required = n - 1 - i;
            int foundIdx = -1;

            for (int j = i; j < n; j++) {
                if (trailingZeros.get(j) >= required) {
                    foundIdx = j;
                    break;
                }
            }

            if (foundIdx == -1) return -1;

            swaps += (foundIdx - i);
            int val = trailingZeros.remove(foundIdx);
            trailingZeros.add(i, val);
        }

        return swaps;
    }
}
