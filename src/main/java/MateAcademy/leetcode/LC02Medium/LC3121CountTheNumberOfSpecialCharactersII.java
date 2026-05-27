package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-the-number-of-special-characters-ii
 */

public class LC3121CountTheNumberOfSpecialCharactersII {
    public static void main(String[] args) {
        System.out.println(numberOfSpecialChars("aaAbcBC")); // 3
        System.out.println(numberOfSpecialChars("abc"));     // 0
        System.out.println(numberOfSpecialChars("AbBCab"));  // 0
    }

    public static int numberOfSpecialChars(String word) {
        int[] lastLower = new int[26];
        int[] firstUpper = new int[26];

        Arrays.fill(lastLower, -1);
        Arrays.fill(firstUpper, -1);

        boolean[] isInvalid = new boolean[26];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (Character.isLowerCase(c)) {
                int idx = c - 'a';
                lastLower[idx] = i;

                if (firstUpper[idx] != -1) {
                    isInvalid[idx] = true;
                }
            } else {
                int idx = c - 'A';
                if (firstUpper[idx] == -1) {
                    firstUpper[idx] = i;
                }
            }
        }

        int specialCount = 0;

        for (int i = 0; i < 26; i++) {
            if (lastLower[i] != -1 && firstUpper[i] != -1 && !isInvalid[i]) {
                specialCount++;
            }
        }

        return specialCount;
    }
}
