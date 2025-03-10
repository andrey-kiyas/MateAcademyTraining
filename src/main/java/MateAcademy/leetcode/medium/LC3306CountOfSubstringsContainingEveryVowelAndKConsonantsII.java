package MateAcademy.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii
 */

public class LC3306CountOfSubstringsContainingEveryVowelAndKConsonantsII {
    public static void main(String[] args) {
        System.out.println(countOfSubstrings("aeioqq", 1));         // 0
        System.out.println(countOfSubstrings("aeiou", 0));          // 1
        System.out.println(countOfSubstrings("ieaouqqieaouqq", 1)); // 3
        System.out.println(countOfSubstrings("iqeaouqi", 2));       // 3
    }

    public static long countOfSubstrings(String word, int k) {
        return find(word, k) - find(word, k + 1);
    }

    private static long find(String word, int k) {
        long result = 0;
        int l = 0, x = 0;
        Map<Character, Integer> count = new HashMap<>(5);

        for (char c : word.toCharArray()) {
            if (vowel(c)) {
                count.merge(c, 1, Integer::sum);
            } else {
                ++x;
            }
            while (x >= k && count.size() == 5) {
                char d = word.charAt(l++);
                if (vowel(d)) {
                    if (count.merge(d, -1, Integer::sum) == 0) {
                        count.remove(d);
                    }
                } else {
                    --x;
                }
            }
            result += l;
        }

        return result;
    }

    private static boolean vowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
