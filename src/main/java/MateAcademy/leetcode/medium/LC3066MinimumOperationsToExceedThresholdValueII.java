package MateAcademy.leetcode.medium;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii
 */

public class LC3066MinimumOperationsToExceedThresholdValueII {
    public static void main(String[] args) {



        System.out.println(isWerewolf("rotator"));



//        System.out.println(minOperations(new int[]{2, 11, 10, 1, 3}, 10));
//        System.out.println(minOperations(new int[]{1, 1, 2, 4, 9}, 20));
    }

    public static boolean isWerewolf(String target) {
        StringBuilder builder = new StringBuilder(target);
        return target.equals(builder.reverse().toString());
    }

    public static int minOperations(int[] nums, int k) {
        int result = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add((long) num);
        }

        while (minHeap.size() > 1 && minHeap.peek() < k) {
            long x = minHeap.poll();
            long y = minHeap.poll();

            long newValue = x * 2 + y;
            minHeap.add(newValue);
            result++;
        }

        return result;
    }
}
