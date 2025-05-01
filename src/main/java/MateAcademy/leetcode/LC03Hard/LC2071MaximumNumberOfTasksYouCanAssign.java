package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign
 */

public class LC2071MaximumNumberOfTasksYouCanAssign {
    public static void main(String[] args) {
        System.out.println(maxTaskAssign(
                new int[]{3, 2, 1},
                new int[]{0, 3, 3},
                1,
                1));                         // 3
        System.out.println(maxTaskAssign(
                new int[]{5, 4}, new int[]{0, 0, 0},
                1,
                5));                         // 1
        System.out.println(maxTaskAssign(
                new int[]{10, 15, 30}, new int[]{0, 10, 10, 10, 10},
                3,
                10));                        // 2
    }

    public static int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int result = 0;
        int left = 0;
        int right = Math.min(tasks.length, workers.length);

        Arrays.sort(tasks);
        Arrays.sort(workers);

        while (left <= right) {
            final int m = (left + right) / 2;
            if (canComplete(tasks, workers, pills, strength, m)) {
                result = m;
                left = m + 1;

            } else {
                right = m - 1;
            }
        }

        return result;
    }

    private static boolean canComplete(int[] tasks, int[] workers, int pillsLeft, int strength, int k) {
        TreeMap<Integer, Integer> sortedWorkers = new TreeMap<>();
        for (int i = workers.length - k; i < workers.length; ++i)
            sortedWorkers.merge(workers[i], 1, Integer::sum);

        for (int i = k - 1; i >= 0; --i) {
            Integer lo = sortedWorkers.ceilingKey(tasks[i]);
            if (lo != null) {
                sortedWorkers.merge(lo, -1, Integer::sum);
                if (sortedWorkers.get(lo) == 0) {
                    sortedWorkers.remove(lo);
                }
            } else if (pillsLeft > 0) {
                lo = sortedWorkers.ceilingKey(tasks[i] - strength);
                if (lo != null) {
                    sortedWorkers.merge(lo, -1, Integer::sum);
                    if (sortedWorkers.get(lo) == 0) {
                        sortedWorkers.remove(lo);
                    }
                    --pillsLeft;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
