package MateAcademy.leetcode.LC01Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-words-containing-character
 */

public class LC2942FindWordsContainingCharacter {
    public static void main(String[] args) {
        String[] words1 = {"leet", "code"};
        char x1 = 'e';
        System.out.println(findWordsContaining(words1, x1)); // [0, 1]

        String[] words2 = {"abc", "bcd", "aaaa", "cbc"};
        char x2 = 'a';
        System.out.println(findWordsContaining(words2, x2)); // [0, 2]

        String[] words3 = {"abc", "bcd", "aaaa", "cbc"};
        char x3 = 'z';
        System.out.println(findWordsContaining(words3, x3)); // []
    }

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }
        return result;
    }
}
