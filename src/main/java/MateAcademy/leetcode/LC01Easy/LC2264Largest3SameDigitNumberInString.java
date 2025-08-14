package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string
 */

public class LC2264Largest3SameDigitNumberInString {
    public static void main(String[] args) {
        System.out.println(largestGoodInteger("6777133339")); // "777"
        System.out.println(largestGoodInteger("2300019"));    // "000"
        System.out.println(largestGoodInteger("42352338"));   // ""
    }

    public static String largestGoodInteger(String num) {
        String maxGood = "";
        for (int i = 0; i <= num.length() - 3; i++) {
            char c = num.charAt(i);
            if (num.charAt(i + 1) == c && num.charAt(i + 2) == c) {
                String candidate = num.substring(i, i + 3);
                if (maxGood.isEmpty() || candidate.compareTo(maxGood) > 0) {
                    maxGood = candidate;
                }
            }
        }
        return maxGood;
    }
}
