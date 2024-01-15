package MateAcademy.codewars.CW8kyu;

import java.util.Arrays;

public class SumArrays {

    public static void main(String[] args) {
        System.out.println(sum(new double[]{1.1, 2.2, 3.3}));
    }

    public static double sum(double[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
