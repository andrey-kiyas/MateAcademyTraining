package MateAcademy.leetcode.LC02Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/finding-pairs-with-a-certain-sum
 */

public class LC1865FindingPairsWithACertainSum {
    public static void main(String[] args) {
        FindSumPairs findSumPairs = new FindSumPairs(
                new int[]{1, 1, 2, 2, 2, 3},
                new int[]{1, 4, 5, 2, 5, 4}
        );

        System.out.println(findSumPairs.count(7)); // Output: 8
        findSumPairs.add(3, 2);
        System.out.println(findSumPairs.count(8)); // Output: 2
        System.out.println(findSumPairs.count(4)); // Output: 1
        findSumPairs.add(0, 1);
        findSumPairs.add(1, 1);
        System.out.println(findSumPairs.count(7)); // Output: 11
    }
}

class FindSumPairs {
    private final int[] nums1;
    private final int[] nums2;
    private final Map<Integer, Integer> freq2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.freq2 = new HashMap<>();
        for (int num : nums2) {
            freq2.put(num, freq2.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = nums2[index];
        int newVal = oldVal + val;

        freq2.put(oldVal, freq2.get(oldVal) - 1);
        if (freq2.get(oldVal) == 0) {
            freq2.remove(oldVal);
        }

        freq2.put(newVal, freq2.getOrDefault(newVal, 0) + 1);
        nums2[index] = newVal;
    }

    public int count(int tot) {
        int count = 0;
        for (int a : nums1) {
            int b = tot - a;
            count += freq2.getOrDefault(b, 0);
        }
        return count;
    }
}
