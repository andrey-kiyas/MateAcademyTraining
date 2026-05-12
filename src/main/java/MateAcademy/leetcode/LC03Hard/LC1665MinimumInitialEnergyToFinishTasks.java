package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks
 */

public class LC1665MinimumInitialEnergyToFinishTasks {
    public static void main(String[] args) {
        // [[1,2],[2,4],[4,8]] -> 8
        System.out.println(minimumEffort(new int[][]{{1, 2}, {2, 4}, {4, 8}}));
        // [[1,3],[2,4],[10,11],[10,12],[8,9]] -> 32
        System.out.println(minimumEffort(new int[][]{{1, 3}, {2, 4}, {10, 11}, {10, 12}, {8, 9}}));
        // [[1,7],[2,8],[3,9],[4,10],[5,11],[6,12]] -> 27
        System.out.println(minimumEffort(new int[][]{{1, 7}, {2, 8}, {3, 9}, {4, 10}, {5, 11}, {6, 12}}));
    }

    public static int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int currentEnergy = 0;
        int initialEnergy = 0;

        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];

            if (currentEnergy < minimum) {
                initialEnergy += (minimum - currentEnergy);
                currentEnergy = minimum;
            }

            currentEnergy -= actual;
        }

        return initialEnergy;
    }
}
