package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/minimum-operations-to-equalize-binary-string
 */

public class LC3666MinimumOperationsToEqualizeBinaryString {
    public static void main(String[] args) {
        System.out.println(minOperations("110", 1));   // 1
        System.out.println(minOperations("0101", 3));  // 2
        System.out.println(minOperations("101", 2));   // -1
    }

    public static int minOperations(String s, int k) {
        int n = s.length();
        int z = 0;
        for (char c : s.toCharArray()) if (c == '0') z++;

        if (z == 0) return 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(z);

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[z] = 0;

        TreeSet<Integer>[] unvisited = new TreeSet[2];
        unvisited[0] = new TreeSet<>();
        unvisited[1] = new TreeSet<>();

        for (int i = 0; i <= n; i++) {
            if (i != z) unvisited[i % 2].add(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            int minI = Math.max(0, k - (n - cur));
            int maxI = Math.min(cur, k);

            int nextMin = cur + k - 2 * maxI;
            int nextMax = cur + k - 2 * minI;

            TreeSet<Integer> targetSet = unvisited[nextMin % 2];

            Integer next = targetSet.ceiling(nextMin);
            while (next != null && next <= nextMax) {
                dist[next] = dist[cur] + 1;
                if (next == 0) return dist[0];
                queue.add(next);

                targetSet.remove(next);
                next = targetSet.ceiling(nextMin);
            }
        }

        return -1;
    }
}
