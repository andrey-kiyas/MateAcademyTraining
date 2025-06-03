package MateAcademy.leetcode.LC03Hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes
 */

public class LC1298MaximumCandiesYouCanGetFromBoxes {
    public static void main(String[] args) {
        int[] status1 = {1, 0, 1, 0};
        int[] candies1 = {7, 5, 4, 100};
        int[][] keys1 = {{}, {}, {1}, {}};
        int[][] containedBoxes1 = {{1, 2}, {3}, {}, {}};
        int[] initialBoxes1 = {0};
        System.out.println(maxCandies(status1, candies1, keys1, containedBoxes1, initialBoxes1)); // 16

        int[] status2 = {1, 0, 0, 0, 0, 0};
        int[] candies2 = {1, 1, 1, 1, 1, 1};
        int[][] keys2 = {{1, 2, 3, 4, 5}, {}, {}, {}, {}, {}};
        int[][] containedBoxes2 = {{1, 2, 3, 4, 5}, {}, {}, {}, {}, {}};
        int[] initialBoxes2 = {0};
        System.out.println(maxCandies(status2, candies2, keys2, containedBoxes2, initialBoxes2)); // 6
    }

    public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length;
        boolean[] used = new boolean[n];
        boolean[] hasKey = new boolean[n];
        boolean[] hasBox = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (status[box] == 1) queue.offer(box);
        }

        int totalCandies = 0;

        while (!queue.isEmpty()) {
            int box = queue.poll();
            if (used[box]) continue;
            used[box] = true;

            totalCandies += candies[box];

            for (int key : keys[box]) {
                if (!hasKey[key]) {
                    hasKey[key] = true;
                    if (hasBox[key] && !used[key]) {
                        queue.offer(key);
                    }
                }
            }

            for (int newBox : containedBoxes[box]) {
                hasBox[newBox] = true;
                if (status[newBox] == 1 || hasKey[newBox]) {
                    queue.offer(newBox);
                }
            }
        }

        return totalCandies;
    }
}
