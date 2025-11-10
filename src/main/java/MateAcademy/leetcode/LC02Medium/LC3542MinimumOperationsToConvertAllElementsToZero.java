package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-operations-to-convert-all-elements-to-zero
 */

public class LC3542MinimumOperationsToConvertAllElementsToZero {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{0, 2}));             // 1
        System.out.println(minOperations(new int[]{3, 1, 2, 1}));       // 3
        System.out.println(minOperations(new int[]{1, 2, 1, 2, 1, 2})); // 4
        System.out.println(minOperations(new int[]{0, 0, 0}));          // 0
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> pos = new HashMap<>();
        int maxV = 0;
        for (int i = 0; i < n; ++i) {
            int v = nums[i];
            if (v <= 0) continue;
            pos.computeIfAbsent(v, k -> new ArrayList<>()).add(i);
            if (v > maxV) maxV = v;
        }
        if (pos.isEmpty()) return 0;

        List<Integer> vals = new ArrayList<>(pos.keySet());
        vals.sort(Comparator.reverseOrder());

        int[] parent = new int[n];
        int[] size = new int[n];
        boolean[] active = new boolean[n];

        for (int i = 0; i < n; ++i) {
            parent[i] = i;
            size[i] = 1;
            active[i] = false;
        }

        final class UF {
            int find(int x) {
                while (parent[x] != x) {
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }
            void union(int a, int b) {
                a = find(a);
                b = find(b);
                if (a == b) return;
                if (size[a] < size[b]) {
                    parent[a] = b;
                    size[b] += size[a];
                } else {
                    parent[b] = a;
                    size[a] += size[b];
                }
            }
        }
        UF uf = new UF();

        int result = 0;
        int[] mark = new int[n];
        int tick = 1;

        for (int v : vals) {
            List<Integer> list = pos.get(v);
            for (int idx : list) {
                active[idx] = true;
                if (idx - 1 >= 0 && active[idx - 1]) {
                    uf.union(idx, idx - 1);
                }
                if (idx + 1 < n && active[idx + 1]) {
                    uf.union(idx, idx + 1);
                }
            }
            int cnt = 0;
            for (int idx : list) {
                int r = uf.find(idx);
                if (mark[r] != tick) {
                    mark[r] = tick;
                    cnt++;
                }
            }
            tick++;
            result += cnt;
        }
        return result;
    }
}
