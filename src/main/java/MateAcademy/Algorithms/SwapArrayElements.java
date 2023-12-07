package MateAcademy.Algorithms;

import java.util.Arrays;

public class SwapArrayElements {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5};

        swapArray(array, 1, 2);

        System.out.println(Arrays.toString(array));
    }

    public static void swapArray(int[] array, int i, int j) {
        // write code here
        int iToJ = array[i];
        int jToI = array[j];
        array[i] = jToI;
        array[j] = iToJ;
    }
}
