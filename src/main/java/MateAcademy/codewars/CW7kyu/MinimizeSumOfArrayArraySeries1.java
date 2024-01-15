package MateAcademy.codewars.CW7kyu;

import java.util.Arrays;

public class MinimizeSumOfArrayArraySeries1 {

    public static void main(String[] args) {
        System.out.println(minSum(new int[]{5, 4, 2, 3}));             // Ожидаемый результат: 22
        System.out.println(minSum(new int[]{12, 6, 10, 26, 3, 24}));   // Ожидаемый результат: 342
        System.out.println(minSum(new int[]{9, 2, 8, 7, 5, 4, 0, 6})); // Ожидаемый результат: 74
    }

    public static int minSum(int[] passed) {
        Arrays.sort(passed);
        int sum = 0;
        for (int i = 0, j = passed.length - 1; i < j; i++, j--) {
            sum += passed[i] * passed[j];
        }
        return sum;
    }
}
