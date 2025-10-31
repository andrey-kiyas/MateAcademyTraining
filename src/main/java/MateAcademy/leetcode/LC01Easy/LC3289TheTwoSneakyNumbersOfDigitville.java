package MateAcademy.leetcode.LC01Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville
 */

public class LC3289TheTwoSneakyNumbersOfDigitville {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSneakyNumbers(new int[]{0, 1, 1, 0})));                         // [0,1]
        System.out.println(Arrays.toString(getSneakyNumbers(new int[]{0, 3, 2, 1, 3, 2})));                   // [2,3]
        System.out.println(Arrays.toString(getSneakyNumbers(new int[]{7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2}))); // [4,5]
    }

    public static int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2;
        int[] count = new int[n];
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            count[num]++;
            if (count[num] == 2) result.add(num);
        }

        return new int[]{result.get(0), result.get(1)};
    }
}
