package MateAcademy.leetcode.LC03Hard;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/maximize-the-number-of-partitions-after-operations
 */

public class LC3003MaximizeTheNumberOfPartitionsAfterOperations {
    public static void main(String[] args) {
        System.out.println(maxPartitionsAfterOperations("accca", 2));  // 3
        System.out.println(maxPartitionsAfterOperations("aabaab", 3)); // 1
        System.out.println(maxPartitionsAfterOperations("xxyz", 1));   // 4
    }

    public static int maxPartitionsAfterOperations(String s, int k) {
        Map<Long, Integer> mem = new HashMap<>();
        return maxPartitionsAfterOperations(s, 0, true, 0, k, mem) + 1;
    }

    private static int maxPartitionsAfterOperations(final String s, int i, boolean canChange, int mask,
                                                    int k, Map<Long, Integer> mem) {
        if (i == s.length())
            return 0;

        Long key = (long) i << 27 | (canChange ? 1 : 0) << 26 | mask;
        if (mem.containsKey(key))
            return mem.get(key);

        int res = getRes(s, i, canChange, mask, 1 << (s.charAt(i) - 'a'), k, mem);

        if (canChange)
            for (int j = 0; j < 26; ++j)
                res = Math.max(res, getRes(s, i, false, mask, 1 << j, k, mem));

        mem.put(key, res);
        return res;
    }

    private static int getRes(final String s, int i, boolean nextCanChange, int mask, int newBit, int k,
                              Map<Long, Integer> mem) {
        final int newMask = mask | newBit;
        if (Integer.bitCount(newMask) > k)
            return 1 + maxPartitionsAfterOperations(s, i + 1, nextCanChange, newBit, k, mem);
        return maxPartitionsAfterOperations(s, i + 1, nextCanChange, newMask, k, mem);
    }
}
