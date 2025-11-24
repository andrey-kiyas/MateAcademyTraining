package MateAcademy.leetcode.LC01Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-prefix-divisible-by-5
 */

public class LC1018BinaryPrefixDivisibleBy5 {
    public static void main(String[] args) {
        System.out.println(prefixesDivBy5(new int[]{0, 1, 1})); // [true, false, false]
        System.out.println(prefixesDivBy5(new int[]{1, 1, 1})); // [false, false, false]
    }

    public static List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> res = new ArrayList<>();
        int remainder = 0;

        for (int bit : nums) {
            remainder = (remainder * 2 + bit) % 5;
            res.add(remainder == 0);
        }

        return res;
    }
}
