package MateAcademy.codewars.CW8kyu;

import java.util.Arrays;

public class BeginnerLostWithoutAMap {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(map(new int[]{1, 2, 3})));
    }

    public static int[] map(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2;
        }
        return arr;
    }
}
