package MateAcademy.codewars.CW7kyu;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/5aa1bcda373c2eb596000112/train/java
 */

public class MaximumTripletSumArraySeries7 {

    public static void main(String[] args) {
        System.out.println(maxTriSum(new int[]{3, 2, 6, 8, 2, 3}));
    }

    public static int maxTriSum(int[] numbers) {
        return Arrays.stream(numbers)
                .distinct()
                .boxed()
                .sorted((a, b) -> b - a)
                .limit(3)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
