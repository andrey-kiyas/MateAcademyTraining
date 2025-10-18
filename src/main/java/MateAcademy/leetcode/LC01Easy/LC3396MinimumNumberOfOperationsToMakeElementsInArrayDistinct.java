package MateAcademy.leetcode.LC01Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct
 */

public class LC3396MinimumNumberOfOperationsToMakeElementsInArrayDistinct {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1, 2, 3, 4, 2, 3, 3, 5, 7})); // 2
        System.out.println(minimumOperations(new int[]{4, 5, 6, 4, 4}));             // 2
        System.out.println(minimumOperations(new int[]{6, 7, 8, 9}));                // 0
    }

    public static int minimumOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) list.add(n);

        int operations = 0;

        while (true) {
            Set<Integer> set = new HashSet<>(list);
            if (set.size() == list.size()) {
                break;
            }

            int removeCount = Math.min(3, list.size());
            if (removeCount > 0) {
                list.subList(0, removeCount).clear();
            }
            operations++;
        }

        return operations;
    }
}
