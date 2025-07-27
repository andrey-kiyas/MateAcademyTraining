package MateAcademy.leetcode.LC02Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-number-of-bad-pairs
 */

public class LC2364CountNumberOfBadPairs {

    public static void main(String[] args) {
        System.out.println(countBadPairs(new int[]{4,1,3,3}));
        System.out.println(countBadPairs(new int[]{1,2,3,4,5}));
    }

    public static long countBadPairs(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        long goodPairs = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            int key = i - nums[i];
            if (countMap.containsKey(key)) {
                goodPairs += countMap.get(key);
            }
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }

        long totalPairs = (n * (n - 1)) / 2;
        return totalPairs - goodPairs;
    }
}
