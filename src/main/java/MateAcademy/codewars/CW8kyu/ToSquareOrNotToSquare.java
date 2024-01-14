package MateAcademy.codewars.CW8kyu;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/57f6ad55cca6e045d2000627/train/java
 */

public class ToSquareOrNotToSquare {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(squareOrSquareRoot(new int[]{4, 3, 9, 7, 2, 1})));
    }

    public static int[] squareOrSquareRoot(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (Math.sqrt(array[i]) % 1 == 0) {
                array[i] = (int) Math.sqrt(array[i]);
            } else {
                array[i] *= array[i];
            }
        }
        return array;
    }
}
