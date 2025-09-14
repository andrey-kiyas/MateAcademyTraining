package MateAcademy.leetcode.LC02Medium;

/*
https://leetcode.com/problems/vowel-spellchecker
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC0966VowelSpellchecker {
    public static void main(String[] args) {
        String[] wordlist1 = {"KiTe","kite","hare","Hare"};
        String[] queries1 = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        System.out.println(Arrays.toString(spellchecker(wordlist1, queries1)));
        // ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]

        String[] wordlist2 = {"yellow"};
        String[] queries2 = {"YellOw"};
        System.out.println(Arrays.toString(spellchecker(wordlist2, queries2)));
        // ["yellow"]
    }

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exact = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        for (String word : wordlist) {
            String lower = word.toLowerCase();
            String devowel = devowel(lower);

            caseInsensitive.putIfAbsent(lower, word);
            vowelInsensitive.putIfAbsent(devowel, word);
        }

        String[] ans = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exact.contains(q)) {
                ans[i] = q;
            } else {
                String lower = q.toLowerCase();
                String devowel = devowel(lower);
                if (caseInsensitive.containsKey(lower)) {
                    ans[i] = caseInsensitive.get(lower);
                } else ans[i] = vowelInsensitive.getOrDefault(devowel, "");
            }
        }
        return ans;
    }

    private static String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                sb.append('*');
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
