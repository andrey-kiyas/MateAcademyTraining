package MateAcademy.leetcode.LC01Easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-largest-group
 */

public class LC1399CountLargestGroup {
    public static void main(String[] args) {
        System.out.println(countLargestGroup(13)); // Output: 4
        System.out.println(countLargestGroup(2));  // Output: 2
    }

    public static int countLargestGroup(int n) {
        Map<Integer, Integer> groupCount = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            groupCount.put(sum, groupCount.getOrDefault(sum, 0) + 1);
        }

        int maxSize = Collections.max(groupCount.values());
        int result = 0;

        for (int count : groupCount.values()) {
            if (count == maxSize) {
                result++;
            }
        }

        return result;

    }

    private static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
