package MateAcademy.leetcode.LC02Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fraction-to-recurring-decimal/description
 */

public class LC0166FractionToRecurringDecimal {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));   // "0.5"
        System.out.println(fractionToDecimal(2, 1));   // "2"
        System.out.println(fractionToDecimal(4, 333)); // "0.(012)"
        System.out.println(fractionToDecimal(-50, 8)); // "-6.25"
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        result.append(num / den);
        long remainder = num % den;

        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");

        Map<Long, Integer> remainderIndex = new HashMap<>();

        while (remainder != 0) {
            if (remainderIndex.containsKey(remainder)) {
                int idx = remainderIndex.get(remainder);
                result.insert(idx, "(");
                result.append(")");
                break;
            }

            remainderIndex.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder / den);
            remainder %= den;
        }

        return result.toString();
    }
}
