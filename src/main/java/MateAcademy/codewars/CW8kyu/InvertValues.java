package MateAcademy.codewars.CW8kyu;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/5899dc03bc95b1bf1b0000ad/train/java
 */

public class InvertValues {

    public static void main(String[] args) {



//        System.out.println(Arrays.toString(invert(new int[]{1, 2, 3, 4, 5})));
    }

    public static int[] invert(int[] array) {
        return Arrays.stream(array).map(i -> -i).toArray();
    }

    public static int[] invert2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= (-1);
        }
        return array;
    }
}
