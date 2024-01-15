package MateAcademy.codewars.CW7kyu;

import java.util.Arrays;
import java.util.Collections;

/**
 * https://www.codewars.com/kata/53d32bea2f2a21f666000256/train/java
 */

public class LargestElements {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(largest(3, new int[]{1, 2, 1, 1})));
    }

    public static int[] largest(int n, int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(n)
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
