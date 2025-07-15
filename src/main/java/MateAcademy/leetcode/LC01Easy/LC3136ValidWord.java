package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/valid-word
 */

public class LC3136ValidWord {
    public static void main(String[] args) {
        System.out.println(isValid("234Adas")); // true
        System.out.println(isValid("b3"));      // false
        System.out.println(isValid("a3$e"));    // false
    }

    public static boolean isValid(String word) {
        if (word.length() < 3) return false;

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char c : word.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) return false;

            if (Character.isLetter(c)) {
                char lower = Character.toLowerCase(c);
                if ("aeiou".indexOf(lower) >= 0) {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }

        return hasVowel && hasConsonant;
    }
}
