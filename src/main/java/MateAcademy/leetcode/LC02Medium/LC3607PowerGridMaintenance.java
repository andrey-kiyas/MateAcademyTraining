package MateAcademy.leetcode.LC02Medium;

/*
  https://leetcode.com/problems/power-grid-maintenance
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeSet;

public class LC3607PowerGridMaintenance {
    public static void main(String[] args) {
        int c1 = 5;
        int[][] connections1 = {{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        int[][] queries1 = {{1, 3}, {2, 1}, {1, 1}, {2, 2}, {1, 2}};
        System.out.println(Arrays.toString(processQueries(c1, connections1, queries1))); // [3, 2, 3]

        int c2 = 3;
        int[][] connections2 = {};
        int[][] queries2 = {{1, 1}, {2, 1}, {1, 1}};
        System.out.println(Arrays.toString(processQueries(c2, connections2, queries2))); // [1, -1]
    }

    public static int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= c; i++) graph.add(new ArrayList<>());
        for (int[] conn : connections) {
            graph.get(conn[0]).add(conn[1]);
            graph.get(conn[1]).add(conn[0]);
        }

        int[] compId = new int[c + 1];
        int compCount = 0;
        for (int i = 1; i <= c; i++) {
            if (compId[i] == 0) {
                compCount++;
                bfsComponent(graph, i, compCount, compId);
            }
        }

        List<TreeSet<Integer>> onlineInComp = new ArrayList<>(compCount + 1);
        for (int i = 0; i <= compCount; i++) onlineInComp.add(new TreeSet<>());
        for (int i = 1; i <= c; i++) {
            onlineInComp.get(compId[i]).add(i);
        }

        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            int cid = compId[x];

            if (type == 1) {
                if (online[x]) ans.add(x);
                else {
                    TreeSet<Integer> ts = onlineInComp.get(cid);
                    ans.add(ts.isEmpty() ? -1 : ts.first());
                }
            } else {
                if (online[x]) {
                    online[x] = false;
                    onlineInComp.get(cid).remove(x);
                }
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }

    private static void bfsComponent(List<List<Integer>> g, int start, int compNum, int[] compId) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        compId[start] = compNum;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nei : g.get(node)) {
                if (compId[nei] == 0) {
                    compId[nei] = compNum;
                    q.offer(nei);
                }
            }
        }
    }
}
