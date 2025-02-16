package MateAcademy.leetcode.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence
 */

public class LC1718ConstructTheLexicographicallyLargestValidSequence {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructDistancedSequence(3))); // [3, 1, 2, 3, 2]
        System.out.println(Arrays.toString(constructDistancedSequence(5))); // [5, 3, 1, 4, 3, 5, 2, 4, 2]
    }

    public static int[] constructDistancedSequence(int n) {
        int size = 2 * n - 1;
        int[] res = new int[size];
        boolean[] used = new boolean[n + 1];

        backtrack(res, used, 0, n);
        return res;
    }

    private static boolean backtrack(int[] res, boolean[] used, int index, int n) {
        if (index == res.length) return true;
        if (res[index] != 0) return backtrack(res, used, index + 1, n);

        for (int num = n; num >= 1; num--) {
            if (used[num]) continue;
            if (num == 1) {
                res[index] = 1;
                used[1] = true;
                if (backtrack(res, used, index + 1, n)) return true;
                res[index] = 0;
                used[1] = false;
            } else {
                int secondIndex = index + num;
                if (secondIndex < res.length && res[secondIndex] == 0) {
                    res[index] = res[secondIndex] = num;
                    used[num] = true;
                    if (backtrack(res, used, index + 1, n)) return true;
                    res[index] = res[secondIndex] = 0;
                    used[num] = false;
                }
            }
        }
        return false;
    }
}
