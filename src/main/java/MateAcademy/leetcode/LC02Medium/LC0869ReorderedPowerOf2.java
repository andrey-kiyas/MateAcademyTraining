package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reordered-power-of-2
 */

public class LC0869ReorderedPowerOf2 {
    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(1));   // true
        System.out.println(reorderedPowerOf2(10));  // false
        System.out.println(reorderedPowerOf2(46));  // true
    }

    public static boolean reorderedPowerOf2(int n) {
        String target = sortDigits(n);

        for (int i = 0; i < 31; i++) {
            int pow2 = 1 << i;
            if (target.equals(sortDigits(pow2))) {
                return true;
            }
        }
        return false;
    }

    private static String sortDigits(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        return new String(digits);
    }
}
