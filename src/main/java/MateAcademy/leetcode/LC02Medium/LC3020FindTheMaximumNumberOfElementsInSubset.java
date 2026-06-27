package MateAcademy.leetcode.LC02Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset
 */

public class LC3020FindTheMaximumNumberOfElementsInSubset {
    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{5, 4, 1, 2, 2})); // 3
        System.out.println(maximumLength(new int[]{1, 3, 2, 4}));    // 1
    }

    public static int maximumLength(int[] nums) {
        Map<Long, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put((long) num, countMap.getOrDefault((long) num, 0) + 1);
        }

        int maxLength = 1;

        if (countMap.containsKey(1L)) {
            int count1 = countMap.get(1L);
            if (count1 % 2 == 0) {
                maxLength = Math.max(maxLength, count1 - 1);
            } else {
                maxLength = Math.max(maxLength, count1);
            }
        }

        for (long x : countMap.keySet()) {
            if (x == 1) {
                continue;
            }

            int currentLength = 0;
            long currentNum = x;

            while (countMap.getOrDefault(currentNum, 0) >= 2) {
                currentLength += 2;
                currentNum = currentNum * currentNum;

                if (currentNum > 1_000_000_000L) {
                    break;
                }
            }

            if (countMap.getOrDefault(currentNum, 0) >= 1) {
                currentLength += 1;
            } else {
                currentLength -= 1;
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
