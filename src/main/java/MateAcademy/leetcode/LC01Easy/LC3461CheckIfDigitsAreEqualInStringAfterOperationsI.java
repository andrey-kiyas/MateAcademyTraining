package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-i
 */

public class LC3461CheckIfDigitsAreEqualInStringAfterOperationsI {
    public static void main(String[] args) {
        System.out.println(hasSameDigits("3902"));   // true
        System.out.println(hasSameDigits("34789"));  // false
        System.out.println(hasSameDigits("999"));    // true
    }

    public static boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder next = new StringBuilder();

            for (int i = 0; i < s.length() - 1; i++) {
                int a = s.charAt(i) - '0';
                int b = s.charAt(i + 1) - '0';
                int sum = (a + b) % 10;
                next.append(sum);
            }

            s = next.toString();
        }

        return s.charAt(0) == s.charAt(1);
    }
}
