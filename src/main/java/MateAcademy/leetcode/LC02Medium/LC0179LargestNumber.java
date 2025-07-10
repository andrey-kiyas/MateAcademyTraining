package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/largest-number
 */

public class LC0179LargestNumber {

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber(new int[]{0, 0}));
    }

    public static String largestNumber(int[] nums) {
        String result = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .reduce((a, b) -> a + b)
                .orElse("0");

        return result.startsWith("0") ? "0" : result;
    }
}
