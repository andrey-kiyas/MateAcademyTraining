package MateAcademy.codewars.CW8kyu;

import java.util.Arrays;
import java.util.Collections;

/**
 * https://www.codewars.com/kata/5b73fe9fb3d9776fbf00009e
 */

public class SumOfDifferencesInArray {

    public static void main(String[] args) {
        System.out.println(sumOfDifferences(new int[]{1, 2, 10}));      // 9
        System.out.println(sumOfDifferences(new int[]{1, 1, 1, 1, 1})); // 0
        System.out.println(sumOfDifferences(new int[]{-17, 17}));       // 34
        System.out.println(sumOfDifferences(new int[]{-1}));            // 0
    }

    public static int sumOfDifferences(int[] arr) {
        int result = 0;
        int[] sortedArray = Arrays.stream(arr)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i = 0; i < sortedArray.length - 1; i++) {
            result += sortedArray[i] - sortedArray[i + 1];
        }
        return result;
    }
}
