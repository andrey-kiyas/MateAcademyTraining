package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-a-safe-walk-through-a-grid
 */

public class LC3286FindASafeWalkThroughAGrid {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        List<List<Integer>> grid1 = List.of(
                List.of(0, 1, 0, 0, 0),
                List.of(0, 1, 0, 1, 0),
                List.of(0, 0, 0, 1, 0)
        );
        System.out.println(findSafeWalk(grid1, 1)); // true

        List<List<Integer>> grid2 = List.of(
                List.of(0, 1, 1, 0, 0, 0),
                List.of(1, 0, 1, 0, 0, 0),
                List.of(0, 1, 1, 1, 0, 1),
                List.of(0, 0, 1, 0, 1, 0)
        );
        System.out.println(findSafeWalk(grid2, 3)); // false
    }

    public static boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] minDamage = new int[m][n];
        for (int[] row : minDamage) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int startDamage = grid.get(0).get(0);
        minDamage[0][0] = startDamage;
        pq.offer(new int[]{startDamage, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int damage = curr[0];
            int r = curr[1];
            int c = curr[2];

            if (r == m - 1 && c == n - 1) {
                return health - damage >= 1;
            }

            if (damage > minDamage[r][c]) {
                continue;
            }

            for (int[] dir : DIRS) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nextDamage = damage + grid.get(nr).get(nc);

                    if (nextDamage < minDamage[nr][nc]) {
                        minDamage[nr][nc] = nextDamage;
                        pq.offer(new int[]{nextDamage, nr, nc});
                    }
                }
            }
        }

        return false;
    }
}
