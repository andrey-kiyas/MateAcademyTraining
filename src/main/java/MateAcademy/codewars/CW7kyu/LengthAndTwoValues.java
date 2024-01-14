package MateAcademy.codewars.CW7kyu;

import java.util.Arrays;

public class LengthAndTwoValues {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(alternate(5, "true", "false")));
        System.out.println(Arrays.toString(alternate(0, "lemons", "apples")));
    }

    public static String[] alternate(int n, String firstValue, String secondValue) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                result[i] = firstValue;
            } else {
                result[i] = secondValue;
            }
        }
        return result;
    }
}
