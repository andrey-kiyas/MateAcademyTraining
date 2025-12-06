package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/count-partitions-with-max-min-difference-at-most-k
 */

public class LC3578CountPartitionsWithMaxMinDifferenceAtMostK {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(countPartitions(new int[]{9, 4, 1, 3, 7}, 4)); // 6
        System.out.println(countPartitions(new int[]{3, 3, 4}, 0));       // 2
    }

    public static int countPartitions(int[] nums, int k) {
        int n = nums.length;

        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];
        dp[0] = 1;
        pref[0] = 1;

        java.util.Deque<Integer> maxQ = new java.util.ArrayDeque<>();
        java.util.Deque<Integer> minQ = new java.util.ArrayDeque<>();

        int left = 0;

        for (int i = 0; i < n; i++) {

            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[i]) {
                maxQ.pollLast();
            }
            maxQ.addLast(i);

            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[i]) {
                minQ.pollLast();
            }
            minQ.addLast(i);

            while (true) {
                if (maxQ.isEmpty() || minQ.isEmpty()) break;

                int maxIdx = maxQ.peekFirst();
                int minIdx = minQ.peekFirst();

                if (nums[maxIdx] - nums[minIdx] <= k) break;

                if (maxIdx == left) maxQ.pollFirst();
                if (minIdx == left) minQ.pollFirst();
                left++;
            }

            long ways = (pref[i] - (left == 0 ? 0 : pref[left - 1])) % MOD;
            if (ways < 0) ways += MOD;

            dp[i + 1] = ways;
            pref[i + 1] = (pref[i] + dp[i + 1]) % MOD;
        }

        return (int) dp[n];
    }
}
