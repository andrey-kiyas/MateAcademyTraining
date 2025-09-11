package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/sort-vowels-in-a-string
 */

public class LC2785SortVowelsInAString {
    public static void main(String[] args) {
        System.out.println(sortVowels("lEetcOde")); // lEOtcede
        System.out.println(sortVowels("lYmpH"));    // lYmpH
    }

    public static String sortVowels(String s) {
        Set<Character> vowelsSet = new HashSet<>(Arrays.asList(
                'a','e','i','o','u','A','E','I','O','U'
        ));

        List<Character> vowels = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (vowelsSet.contains(c)) {
                vowels.add(c);
            }
        }

        Collections.sort(vowels);

        StringBuilder result = new StringBuilder();
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (vowelsSet.contains(c)) {
                result.append(vowels.get(idx++));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
