package MateAcademy.leetcode.LC02Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words
 */

public class LC2131LongestPalindromeByConcatenatingTwoLetterWords {
    public static void main(String[] args) {
        System.out.println(longestPalindrome(new String[]{"lc", "cl", "gg"}));                   // 6
        System.out.println(longestPalindrome(new String[]{"ab", "ty", "yt", "lc", "cl", "ab"})); // 8
        System.out.println(longestPalindrome(new String[]{"cc", "ll", "xx"}));                   // 2
    }

    public static int longestPalindrome(String[] words) {
        Map<String, Integer> freq = new HashMap<>();
        int length = 0;
        boolean hasCenter = false;

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        for (String word : freq.keySet()) {
            String reversed = new StringBuilder(word).reverse().toString();

            if (!word.equals(reversed) && freq.containsKey(reversed)) {
                int pairs = Math.min(freq.get(word), freq.get(reversed));
                length += pairs * 4;
                freq.put(word, freq.get(word) - pairs);
                freq.put(reversed, freq.get(reversed) - pairs);
            }
        }

        for (String word : freq.keySet()) {
            if (word.charAt(0) == word.charAt(1)) {
                int count = freq.get(word);
                int pairs = count / 2;
                length += pairs * 4;
                if (count % 2 == 1) {
                    hasCenter = true;
                }
            }
        }

        if (hasCenter) {
            length += 2;
        }

        return length;
    }
}
