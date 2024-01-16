package MateAcademy.codewars.CW7kyu;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/5a87449ab1710171300000fd/train/java
 */

public class TidyNumberSpecialNumbersSeries9 {

    public static void main(String[] args) {
        System.out.println(tidyNumber(13579));  // ==> return (true)
    }

    public static boolean tidyNumber(int number) {
        int[] digits = Integer.toString(number)
                .chars()
                .map(Character::getNumericValue)
                .toArray();
        return Arrays.equals(digits, Arrays.stream(digits)
                .sorted()
                .toArray()
        );
    }
}
