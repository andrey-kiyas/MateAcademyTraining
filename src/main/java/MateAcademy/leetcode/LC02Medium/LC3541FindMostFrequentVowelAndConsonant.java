package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-most-frequent-vowel-and-consonant
 */

public class LC3541FindMostFrequentVowelAndConsonant {
    public static void main(String[] args) {
        System.out.println(maxFreqSum("successes")); // 6
        System.out.println(maxFreqSum("aeiaeia"));   // 3
    }

    public static int maxFreqSum(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxVowel = 0;
        int maxCons = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                char c = (char)(i + 'a');
                if (vowels.contains(c)) {
                    maxVowel = Math.max(maxVowel, freq[i]);
                } else {
                    maxCons = Math.max(maxCons, freq[i]);
                }
            }
        }

        return maxVowel + maxCons;
    }
}
