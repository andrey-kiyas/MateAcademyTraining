package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/zero-array-transformation-iii
 */

public class LC3362ZeroArrayTransformationIII {
    public static void main(String[] args) {
        int[] nums1 = {2, 0, 2};
        int[][] queries1 = {{0, 2}, {0, 2}, {1, 1}};
        System.out.println(maxRemoval(nums1, queries1));  // 1

        int[] nums2 = {1, 1, 1, 1};
        int[][] queries2 = {{1, 3}, {0, 2}, {1, 3}, {1, 2}};
        System.out.println(maxRemoval(nums2, queries2));  // 2

        int[] nums3 = {1, 2, 3, 4};
        int[][] queries3 = {{0, 3}};
        System.out.println(maxRemoval(nums3, queries3));  // -1
    }

    public static int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        PriorityQueue<Integer> usedQuery = new PriorityQueue<>();
        PriorityQueue<Integer> availableQuery = new PriorityQueue<>(Collections.reverseOrder());

        Arrays.sort(queries, Comparator.comparingInt(a -> a[0]));

        int queryPos = 0;
        int appliedCount = 0;

        for (int i = 0; i < n; i++) {
            while (queryPos < queries.length && queries[queryPos][0] == i) {
                availableQuery.offer(queries[queryPos][1]);
                queryPos++;
            }

            nums[i] -= usedQuery.size();

            while (nums[i] > 0 && !availableQuery.isEmpty() && availableQuery.peek() >= i) {
                int end = availableQuery.poll();
                usedQuery.offer(end);
                nums[i]--;
                appliedCount++;
            }

            if (nums[i] > 0) {
                return -1;
            }

            while (!usedQuery.isEmpty() && usedQuery.peek() == i) {
                usedQuery.poll();
            }
        }

        return queries.length - appliedCount;
    }
}
