package MateAcademy.leetcode.LC02Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/smallest-missing-non-negative-integer-after-operations
 */

public class LC2598SmallestMissingNonNegativeIntegerAfterOperations {
    public static void main(String[] args) {
        System.out.println(findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 5)); // 4
        System.out.println(findSmallestInteger(new int[]{1, -10, 7, 13, 6, 8}, 7)); // 2

        System.out.println(findSmallestInteger2(new int[]{1, -10, 7, 13, 6, 8}, 5)); // 4
        System.out.println(findSmallestInteger2(new int[]{1, -10, 7, 13, 6, 8}, 7)); // 2
    }

    public static int findSmallestInteger(int[] nums, int value) {
        int[] counts = new int[value];

        for (int n : nums) {
            int remainder = (n % value + value) % value;
            counts[remainder]++;
        }

        int mex = 0;

        while (true) {
            int required_remainder = mex % value;

            if (counts[required_remainder] > 0) {
                counts[required_remainder]--;
                mex++;
            } else {
                break;
            }
        }

        return mex;
    }

    public static int findSmallestInteger2(int[] nums, int value) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            int mod = ((num % value) + value) % value;
            count.put(mod, count.getOrDefault(mod, 0) + 1);
        }

        int mex = 0;
        while (true) {
            int mod = mex % value;
            if (!count.containsKey(mod) || count.get(mod) == 0) {
                return mex;
            }
            count.put(mod, count.get(mod) - 1);
            mex++;
        }
    }
}
