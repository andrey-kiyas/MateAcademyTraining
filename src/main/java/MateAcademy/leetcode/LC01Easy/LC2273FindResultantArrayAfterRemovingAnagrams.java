package MateAcademy.leetcode.LC01Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/find-resultant-array-after-removing-anagrams
 */

public class LC2273FindResultantArrayAfterRemovingAnagrams {
    public static void main(String[] args) {
        System.out.println(removeAnagrams(new String[]{"abba", "baba", "bbaa", "cd", "cd"}));  // [abba, cd]
        System.out.println(removeAnagrams(new String[]{"a", "b", "c", "d", "e"}));             // [a, b, c, d, e]
    }

    public static List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        String prev = "";

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            if (!sorted.equals(prev)) {
                result.add(word);
                prev = sorted;
            }
        }

        return result;
    }
}
