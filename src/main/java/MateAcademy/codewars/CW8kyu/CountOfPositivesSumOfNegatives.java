package MateAcademy.codewars.CW8kyu;

import java.util.Arrays;

public class CountOfPositivesSumOfNegatives {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countPositivesSumNegatives(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14, -15})));
    }

    public static int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[]{};
        }
        int count = 0, sum = 0;
        for (int num : input) {
            if (num > 0) {
                count++;
            } else {
                sum += num;
            }
        }
        return new int[]{count, sum};
    }
}
