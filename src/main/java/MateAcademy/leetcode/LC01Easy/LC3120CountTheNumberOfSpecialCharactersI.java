package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/count-the-number-of-special-characters-i
 */

public class LC3120CountTheNumberOfSpecialCharactersI {
    public static void main(String[] args) {
        System.out.println(numberOfSpecialChars("aaAbcBC")); // 3
        System.out.println(numberOfSpecialChars("abc"));     // 0
        System.out.println(numberOfSpecialChars("abBCab"));  // 1
    }

    public static int numberOfSpecialChars(String word) {
        boolean[] lowerSeen = new boolean[26];
        boolean[] upperSeen = new boolean[26];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                lowerSeen[c - 'a'] = true;
            } else if (Character.isUpperCase(c)) {
                upperSeen[c - 'A'] = true;
            }
        }

        int specialCount = 0;

        for (int i = 0; i < 26; i++) {
            if (lowerSeen[i] && upperSeen[i]) {
                specialCount++;
            }
        }

        return specialCount;
    }
}
