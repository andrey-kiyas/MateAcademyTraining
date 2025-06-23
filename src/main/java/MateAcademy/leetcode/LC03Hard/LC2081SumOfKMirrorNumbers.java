package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sum-of-k-mirror-numbers
 */

public class LC2081SumOfKMirrorNumbers {
    public static void main(String[] args) {
        System.out.println(kMirror(2, 5));   // Output: 25
        System.out.println(kMirror(3, 7));   // Output: 499
        System.out.println(kMirror(7, 17));  // Output: 20379000
    }

    public static long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;

        while (count < n) {
            for (long p : generatePalindromes(length)) {
                if (isPalindrome(toBaseK(p, k))) {
                    sum += p;
                    count++;
                    if (count == n) break;
                }
            }
            length++;
        }

        return sum;
    }

    private static List<Long> generatePalindromes(int len) {
        List<Long> res = new ArrayList<>();
        int halfLen = (len + 1) / 2;
        long start = (long) Math.pow(10, halfLen - 1);
        long end = (long) Math.pow(10, halfLen);

        for (long i = start; i < end; i++) {
            String left = String.valueOf(i);
            String right = new StringBuilder(left.substring(0, len % 2 == 0 ? left.length() : left.length() - 1)).reverse().toString();
            res.add(Long.parseLong(left + right));
        }

        return res;
    }

    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    private static String toBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }
}
