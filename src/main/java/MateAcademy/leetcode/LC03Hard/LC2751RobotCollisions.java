package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

/**
 * dsfsf
 */

public class LC2751RobotCollisions {
    public static void main(String[] args) {
        int[] pos1 = {5, 4, 3, 2, 1};
        int[] health1 = {2, 17, 9, 15, 10};
        String dir1 = "RRRRR";
        System.out.println(survivedRobotsHealths(pos1, health1, dir1)); // [2, 17, 9, 15, 10]

        int[] pos2 = {3, 5, 2, 6};
        int[] health2 = {10, 10, 15, 12};
        String dir2 = "RLRL";
        System.out.println(survivedRobotsHealths(pos2, health2, dir2)); // [14]
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        Arrays.sort(indices, Comparator.comparingInt(i -> positions[i]));

        Deque<Integer> stack = new ArrayDeque<>(); // Зберігаємо індекси "правих" роботів

        for (int i : indices) {
            if (directions.charAt(i) == 'R') {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && healths[i] > 0) {
                    int top = stack.pop();

                    if (healths[i] > healths[top]) {
                        healths[i] -= 1;
                        healths[top] = 0;
                    } else if (healths[i] < healths[top]) {
                        healths[top] -= 1;
                        healths[i] = 0;
                        stack.push(top);
                    } else {
                        healths[i] = 0;
                        healths[top] = 0;
                    }
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int h : healths) {
            if (h > 0) result.add(h);
        }
        return result;
    }
}
