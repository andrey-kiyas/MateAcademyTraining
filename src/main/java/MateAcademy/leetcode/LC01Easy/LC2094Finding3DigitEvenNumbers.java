package MateAcademy.leetcode.LC01Easy;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/finding-3-digit-even-numbers
 */

public class LC2094Finding3DigitEvenNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                findEvenNumbers(new int[]{2, 1, 3, 0})));    // [102,120,130,132,210,230,302,310,312,320]
        System.out.println(Arrays.toString(
                findEvenNumbers(new int[]{2, 2, 8, 8, 2}))); // [222,228,282,288,822,828,882]
        System.out.println(Arrays.toString(
                findEvenNumbers(new int[]{3, 7, 5})));       // []
    }

    public static int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new TreeSet<>();

        int n = digits.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == j || i == k || j == k) continue;

                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    if (digits[i] != 0 && num % 2 == 0) {
                        result.add(num);
                    }
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
