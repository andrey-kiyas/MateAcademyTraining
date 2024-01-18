package MateAcademy.leetcode.hard;

/**
 * https://leetcode.com/problems/integer-to-english-words
 */

public class IntegerToEnglishWords273 {
    private static final String[] BELOW_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public static void main(String[] args) {
        System.out.println(numberToWords(123));      // Output: "One Hundred Twenty Three"
        System.out.println(numberToWords(12345));    // Output: "Twelve Thousand Three Hundred Forty Five"
        System.out.println(numberToWords(1234567));  // Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
    }

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int i = 0;
        String words = "";
        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            }
            num /= 1000;
            i++;
        }
        return words.trim();
    }

    private static String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return BELOW_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return BELOW_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
