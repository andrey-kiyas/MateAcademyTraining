package MateAcademy.leetcode.LC01Easy;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/palindrome-number/
 */

public class LC0009PalindromeNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(isPalindrome(scanner.nextInt()));
    }

    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversed = 0;
        int original = x;

        while (x > 0) {
            int lastDigit = x % 10;
            reversed = reversed * 10 + lastDigit;
            x /= 10;
        }

        return original == reversed;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        String s = new String(String.valueOf(x));

        for (int j = 0; j < s.length() / 2; j++) {
            if (s.charAt(j) != s.charAt(s.length() - 1 - j)) {
                return false;
            }
        }

        return true;
    }
}
