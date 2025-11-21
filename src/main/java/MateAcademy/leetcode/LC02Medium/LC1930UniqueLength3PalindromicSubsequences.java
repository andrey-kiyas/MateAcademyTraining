package MateAcademy.leetcode.LC02Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-length-3-palindromic-subsequences
 */

public class LC1930UniqueLength3PalindromicSubsequences {
    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));     // 3
        System.out.println(countPalindromicSubsequence("adc"));       // 0
        System.out.println(countPalindromicSubsequence("bbcbaba"));   // 4
    }

    public static int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];

        for (int i = 0; i < 26; i++) {
            first[i] = -1;
            last[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) first[c] = i;
            last[c] = i;
        }

        Set<String> seen = new HashSet<>();

        for (int c = 0; c < 26; c++) {
            int L = first[c];
            int R = last[c];

            if (L == -1 || R == -1 || L >= R) continue;

            boolean[] middleUsed = new boolean[26];

            for (int i = L + 1; i < R; i++) {
                int m = s.charAt(i) - 'a';
                if (!middleUsed[m]) {
                    middleUsed[m] = true;
                    String pal = "" + (char) (c + 'a') + (char) (m + 'a') + (char) (c + 'a');
                    seen.add(pal);
                }
            }
        }

        return seen.size();
    }
}
