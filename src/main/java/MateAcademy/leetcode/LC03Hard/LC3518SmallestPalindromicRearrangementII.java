package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/smallest-palindromic-rearrangement-ii
 */

public class LC3518SmallestPalindromicRearrangementII {
    public static void main(String[] args) {
        System.out.println(smallestPalindrome("abba", 2));  // baab
        System.out.println(smallestPalindrome("aa", 2));    // ""
        System.out.println(smallestPalindrome("bacab", 1)); // abcba
    }

    public static String smallestPalindrome(String s, int k) {
        int n = s.length();
        int halfLen = n / 2;

        int[] count = new int[26];
        for (int i = 0; i < halfLen; i++) {
            count[s.charAt(i) - 'a']++;
        }

        long totalPermutations = countPermutations(count, halfLen, k);
        if (totalPermutations < k) {
            return "";
        }

        char[] left = new char[halfLen];
        int remainingLen = halfLen;

        for (int i = 0; i < halfLen; i++) {
            for (int c = 0; c < 26; c++) {
                if (count[c] == 0) {
                    continue;
                }

                count[c]--;
                long countWithC = countPermutations(count, remainingLen - 1, k);

                if (countWithC >= k) {
                    left[i] = (char) ('a' + c);
                    remainingLen--;
                    break;
                } else {
                    k -= countWithC;
                    count[c]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(left);

        if (n % 2 != 0) {
            sb.append(s.charAt(halfLen));
        }

        for (int i = halfLen - 1; i >= 0; i--) {
            sb.append(left[i]);
        }

        return sb.toString();
    }

    private static long countPermutations(int[] count, int total, long limit) {
        long res = 1;
        int currentTotal = 0;

        for (int c : count) {
            if (c == 0) continue;
            for (int j = 1; j <= c; j++) {
                currentTotal++;
                res = res * currentTotal / j;
                if (res > limit) {
                    return limit + 1;
                }
            }
        }
        return res;
    }
}
