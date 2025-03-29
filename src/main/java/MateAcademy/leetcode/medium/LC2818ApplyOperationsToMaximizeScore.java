package MateAcademy.leetcode.medium;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/apply-operations-to-maximize-score
 */

public class LC2818ApplyOperationsToMaximizeScore {
    public static void main(String[] args) {
        System.out.println(maximumScore(Arrays.asList(8, 3, 9, 3, 8), 2));          // 81
        System.out.println(maximumScore(Arrays.asList(19, 12, 14, 6, 10, 18), 3));  // 4788
    }

    public static int maximumScore(List<Integer> nums, int k) {
        int n = nums.size();
        int[] counts = new int[n];
        for (int i = 0; i < n; i++) {
            counts[i] = cntOfDistinctPF(nums.get(i));
        }
        final int MOD = (int) 1e9 + 7;
        BigInteger ans = BigInteger.ONE;

        long[] sums = new long[n];
        LinkedList<Integer> stack = new LinkedList<>();     // 最小栈
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && counts[i] > counts[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                sums[i] = i + 1;
            } else {
                sums[i] = i - stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && counts[i] >= counts[stack.peek()]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                sums[i] += (sums[i] * (n - i - 1));
            } else {
                sums[i] += (sums[i] * (stack.peek() - i - 1));
            }
            stack.push(i);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{nums.get(i), i});
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] poll = pq.poll();
            long cnt = Math.min(k, sums[poll[1]]);
            BigInteger cur = BigInteger.valueOf(poll[0]).modPow(BigInteger.valueOf(cnt), BigInteger.valueOf(MOD));
            ans = ans.multiply(cur).mod(BigInteger.valueOf(MOD));
            k -= (int) cnt;
        }

        return ans.intValue();
    }

    private static int cntOfDistinctPF(int num) {
        int cnt = 0;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                cnt++;
                while (num % i == 0) {
                    num /= i;
                }
            }
        }
        if (num > 1) {
            cnt++;
        }
        return cnt;
    }
}
