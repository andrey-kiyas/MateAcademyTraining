package MateAcademy.codewars;

import java.util.Arrays;
import java.util.List;

public class SumMixedArray {

    public static void main(String[] args) {
        System.out.println(sum(Arrays.asList("3", 6, 6, 0, "5", 8, 5, "6", 2, "0")));
        System.out.println(sum(Arrays.asList("3", 6)));
    }

    /*
     * Assume input will be only of Integer o String type
     */
    public static int sum(List<?> mixed) {
        int result = 0;
        for (int i = 0; i < mixed.size(); i++) {
            result += Integer.parseInt(mixed.get(i).toString());
        }
        return result;
    }
}
