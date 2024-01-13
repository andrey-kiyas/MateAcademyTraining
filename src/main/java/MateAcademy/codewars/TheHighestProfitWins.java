package MateAcademy.codewars;

import java.util.Arrays;

public class TheHighestProfitWins {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minMax(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(minMax(new int[]{2334454, 5})));
        System.out.println(Arrays.toString(minMax(new int[]{1})));
    }

    public static int[] minMax(int[] arr) {
        // Your awesome code here
        int[] result = {arr[0], arr[0]};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < result[0]) {
                result[0] = arr[i];
            }
            if (arr[i] > result[1]) {
                result[1] = arr[i];
            }
        }
        return result;
    }

}
