package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/integer-to-roman
 */

public class IntegerToRoman12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(3));      // Output: "III"
        System.out.println(intToRoman(58));     // Output: "LVIII"
        System.out.println(intToRoman(1994));   // Output: "MCMXCIV"
    }

    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(symbols[i]);
            }
        }
        return result.toString();
    }
}
