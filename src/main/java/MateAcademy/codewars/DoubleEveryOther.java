package MateAcademy.codewars;

import java.util.Arrays;

public class DoubleEveryOther {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(doubleEveryOther(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(doubleEveryOther(new int[]{1, 19, 6, 2, 12, -3})));
        System.out.println(Arrays.toString(doubleEveryOther(new int[]{-1000, 1653, 210, 0, 1})));
    }

    public static int[] doubleEveryOther(int[] a) {
        //solution
        for (int i = 0; i < a.length; i++) {
            if (i % 2 != 0) {
                a[i] = a[i] * 2;
            }
        }
        return a;
    }
}
