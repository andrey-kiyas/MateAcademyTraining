package MateAcademy.codewars.CW7kyu;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/559cc2d2b802a5c94700000c/train/java
 */

public class HowManyConsecutiveNumbersAreNeeded {

    public static void main(String[] args) {
        System.out.println(consecutive(new int[]{4, 8, 6}));     // 2
        System.out.println(consecutive(new int[]{1, 2, 3, 4}));  // 0
        System.out.println(consecutive(new int[]{}));            // 0
        System.out.println(consecutive(new int[]{1}));           // 0
    }

    public static int consecutive(final int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        return arr[arr.length - 1] - arr.length - arr[0] + 1;
    }
}
