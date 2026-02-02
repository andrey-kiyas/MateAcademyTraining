package MateAcademy.leetcode.LC03Hard;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/divide-an-array-into-subarrays-with-minimum-cost-ii
 */

public class LC3013DivideAnArrayIntoSubarraysWithMinimumCostII {
    private static final TreeSet<Pair> leftSet = new TreeSet<>();
    private static final TreeSet<Pair> rightSet = new TreeSet<>();
    private static long currentSum = 0;
    private static int m;

    public static void main(String[] args) {
        System.out.println(minimumCost(new int[]{1, 3, 2, 6, 4, 2}, 3, 3));  // 5
        System.out.println(minimumCost(new int[]{10, 1, 2, 2, 2, 1}, 4, 3)); // 15
        System.out.println(minimumCost(new int[]{10, 8, 18, 9}, 3, 1));      // 36
    }

    public static long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        m = k - 1;
        leftSet.clear();
        rightSet.clear();
        currentSum = 0;

        for (int i = 1; i <= dist + 1; i++) {
            add(new Pair(nums[i], i));
        }

        long minTotalCost = nums[0] + currentSum;

        for (int i = 2; i <= n - dist - 1; i++) {
            remove(new Pair(nums[i - 1], i - 1));
            add(new Pair(nums[i + dist], i + dist));

            minTotalCost = Math.min(minTotalCost, nums[0] + currentSum);
        }

        return minTotalCost;
    }

    private static void add(Pair p) {
        leftSet.add(p);
        currentSum += p.val;
        if (leftSet.size() > m) {
            Pair last = leftSet.pollLast();
            assert last != null;
            currentSum -= last.val;
            rightSet.add(last);
        }
    }

    private static void remove(Pair p) {
        if (leftSet.contains(p)) {
            leftSet.remove(p);
            currentSum -= p.val;
            if (!rightSet.isEmpty()) {
                Pair first = rightSet.pollFirst();
                leftSet.add(first);
                assert first != null;
                currentSum += first.val;
            }
        } else {
            rightSet.remove(p);
        }
    }

    private static class Pair implements Comparable<Pair> {
        int val, idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.val != other.val) return Integer.compare(this.val, other.val);
            return Integer.compare(this.idx, other.idx);
        }
    }
}
