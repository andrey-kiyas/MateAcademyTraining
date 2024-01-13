package MateAcademy.codewars;

import java.util.Arrays;

public class RowWeights {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rowWeights(new int[]{100, 50})));
        System.out.println(Arrays.toString(rowWeights(new int[]{50, 60, 70, 80})));
    }

    public static int[] rowWeights(final int[] weights) {
        int[] ints = {0, 0};
        for (int i = 0; i < weights.length; i++) {
            if (i % 2 == 0) {
                ints[0] += weights[i];
            } else {
                ints[1] += weights[i];
            }

        }
        return ints; // Do your magic!
    }
}
