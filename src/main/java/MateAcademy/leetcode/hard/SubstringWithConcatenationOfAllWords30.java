package MateAcademy.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words
 */

public class SubstringWithConcatenationOfAllWords30 {

    public static void main(String[] args) {
        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo", "bar"};
        System.out.println(findSubstring(s1, words1));  // Output: [0, 9]

        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word", "good", "best", "word"};
        System.out.println(findSubstring(s2, words2));  // Output: []

        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar", "foo", "the"};
        System.out.println(findSubstring(s3, words3));  // Output: [6, 9, 12]
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }
        int wordLength = words[0].length();
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < wordLength; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> currentCount = new HashMap<>();
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;
                if (wordCount.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);
                    count++;
                    while (currentCount.getOrDefault(word, 0) > wordCount.getOrDefault(word, 0)) {
                        String leftWord = s.substring(left, left + wordLength);
                        left += wordLength;
                        currentCount.put(leftWord, currentCount.getOrDefault(leftWord, 0) - 1);
                        count--;
                    }
                    if (count == words.length) {
                        result.add(left);
                    }
                } else {
                    left = right;
                    count = 0;
                    currentCount.clear();
                }
            }
        }
        return result;
    }
}
