package MateAcademy.codewars.CW8kyu;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/54edbc7200b811e956000556/train/java
 */

public class CountingSheeps {

    public static void main(String[] args) {
        Boolean[] array1 = {true, true, true, false,
                true, true, true, true,
                true, false, true, false,
                true, false, false, true,
                true, true, true, true,
                false, false, true, true};
        System.out.println(countSheeps(array1));
    }

    public static int countSheeps(Boolean[] arrayOfSheeps) {
        if (arrayOfSheeps == null) {
            return 0;
        }
        return (int) Arrays.stream(arrayOfSheeps)
                .filter(Boolean.TRUE::equals) // Keep only true values
                .count();
    }

    public static int countSheeps2(Boolean[] arrayOfSheeps) {
        int counter = 0;
        for (Boolean bol : arrayOfSheeps) {
            if (bol) {
                counter++;
            }
        }
        return counter;
    }
}
