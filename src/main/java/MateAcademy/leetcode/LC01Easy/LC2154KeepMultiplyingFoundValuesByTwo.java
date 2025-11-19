package MateAcademy.leetcode.LC01Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/keep-multiplying-found-values-by-two
 */

public class LC2154KeepMultiplyingFoundValuesByTwo {
    public static void main(String[] args) {
        System.out.println(findFinalValue(new int[]{5,3,6,1,12}, 3)); // 24
        System.out.println(findFinalValue(new int[]{2,7,9}, 4));      // 4
    }

    public static int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        while (set.contains(original)) {
            original *= 2;
        }

        return original;
    }
}
