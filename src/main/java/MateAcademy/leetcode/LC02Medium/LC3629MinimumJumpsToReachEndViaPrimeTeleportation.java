package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-jumps-to-reach-end-via-prime-teleportation
 */

public class LC3629MinimumJumpsToReachEndViaPrimeTeleportation {
    private static final int MAX_VAL = 1_000_001;
    private static final int[] minPrime;

    static {
        minPrime = new int[MAX_VAL];
        for (int i = 2; i * i < MAX_VAL; i++) {
            if (minPrime[i] == 0) {
                for (int j = i * i; j < MAX_VAL; j += i) {
                    if (minPrime[j] == 0) minPrime[j] = i;
                }
            }
        }
        for (int i = 2; i < MAX_VAL; i++) {
            if (minPrime[i] == 0) minPrime[i] = i;
        }
    }

    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{1, 2, 4, 6}));    // 2
        System.out.println(minJumps(new int[]{2, 3, 4, 7, 9})); // 2
        System.out.println(minJumps(new int[]{4, 6, 5, 8}));    // 3
    }

    public static int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        Map<Integer, List<Integer>> primeToIndices = new HashMap<>();
        Set<Integer> visitedPrimes = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            while (temp > 1) {
                int p = minPrime[temp];
                primeToIndices.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                while (temp % p == 0) temp /= p;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visitedIndices = new boolean[n];

        queue.add(0);
        visitedIndices[0] = true;
        int jumps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer currObj = queue.poll();

                if (currObj == null) continue;

                int curr = currObj;

                if (curr == n - 1) return jumps;

                if (curr + 1 < n && !visitedIndices[curr + 1]) {
                    visitedIndices[curr + 1] = true;
                    queue.add(curr + 1);
                }
                if (curr - 1 >= 0 && !visitedIndices[curr - 1]) {
                    visitedIndices[curr - 1] = true;
                    queue.add(curr - 1);
                }

                int val = nums[curr];
                if (val >= 2 && minPrime[val] == val) {
                    if (!visitedPrimes.contains(val)) {
                        visitedPrimes.add(val);
                        for (int nextIdx : primeToIndices.getOrDefault(val, Collections.emptyList())) {
                            if (!visitedIndices[nextIdx]) {
                                visitedIndices[nextIdx] = true;
                                queue.add(nextIdx);
                            }
                        }
                    }
                }
            }
            jumps++;
        }

        return -1;
    }
}
