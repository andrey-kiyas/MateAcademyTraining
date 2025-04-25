package MateAcademy.leetcode.LC02Medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-of-interesting-subarrays
 */

public class LC2845CountOfInterestingSubarrays {
    public static void main(String[] args) {
        System.out.println(countInterestingSubarrays(List.of(3, 2, 4), 2, 1));    // 3
        System.out.println(countInterestingSubarrays(List.of(3, 1, 9, 6), 3, 0)); // 2
    }

    public static long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> countMap = new HashMap<>();
        countMap.put(0, 1L);
        long res = 0;
        int prefix = 0;

        for (int num : nums) {
            if (num % modulo == k) {
                prefix++;
            }

            int target = (prefix - k + modulo) % modulo;
            res += countMap.getOrDefault(target, 0L);

            int mod = prefix % modulo;
            countMap.put(mod, countMap.getOrDefault(mod, 0L) + 1);
        }

        return res;
    }
}
