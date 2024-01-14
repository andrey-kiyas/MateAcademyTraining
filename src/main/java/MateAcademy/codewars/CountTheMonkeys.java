package MateAcademy.codewars;

import java.util.Arrays;

public class CountTheMonkeys {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(monkeyCount(5)));
    }

    public static int[] monkeyCount(final int n) {
        int[] result = new int[n];
        for (int i = 1; i <= n; i++) {
            result[i - 1] = i;
        }
        return result;
    }
}
