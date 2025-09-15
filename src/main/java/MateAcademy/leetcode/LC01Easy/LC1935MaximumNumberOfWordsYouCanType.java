package MateAcademy.leetcode.LC01Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/maximum-number-of-words-you-can-type
 */

public class LC1935MaximumNumberOfWordsYouCanType {
    public static void main(String[] args) {
        System.out.println(canBeTypedWords("hello world", "ad")); // 1
        System.out.println(canBeTypedWords("leet code", "lt"));   // 1
        System.out.println(canBeTypedWords("leet code", "e"));    // 0
    }

    public static int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> broken = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            broken.add(c);
        }

        String[] words = text.split(" ");
        int count = 0;

        for (String word : words) {
            boolean valid = true;
            for (char c : word.toCharArray()) {
                if (broken.contains(c)) {
                    valid = false;
                    break;
                }
            }
            if (valid) count++;
        }
        return count;
    }
}
