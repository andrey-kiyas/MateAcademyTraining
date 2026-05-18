package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/jump-game-iv/description
 */

public class LC1345JumpGameIV {
    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404})); // 3
        System.out.println(minJumps(new int[]{7}));                                           // 0
        System.out.println(minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7}));                      // 1
    }

    public static int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.add(0);
        visited[0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer currObj = queue.poll();
                if (currObj == null) continue;
                int curr = currObj;

                if (curr == n - 1) return steps;

                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.add(curr + 1);
                }

                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.add(curr - 1);
                }

                int currentVal = arr[curr];
                if (valueToIndices.containsKey(currentVal)) {
                    for (int nextIdx : valueToIndices.get(currentVal)) {
                        if (!visited[nextIdx]) {
                            visited[nextIdx] = true;
                            queue.add(nextIdx);
                        }
                    }
                    valueToIndices.remove(currentVal);
                }
            }
            steps++;
        }

        return -1;
    }
}
