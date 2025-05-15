package MateAcademy.leetcode.LC01Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i
 */

public class LC2900LongestUnequalAdjacentGroupsSubsequenceI {






    public static void main(String[] args) {
        System.out.println(getLongestSubsequence(
                new String[]{"e", "a", "b"},
                new int[]{0, 0, 1}
        ));                                          // ["e", "b"]

        System.out.println(getLongestSubsequence(
                new String[]{"a", "b", "c", "d"},
                new int[]{1, 0, 1, 1}
        ));                                          // ["a", "b", "c"]
    }

    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int n = words.length;

        if (n == 0) return result;

        result.add(words[0]);
        int lastGroup = groups[0];

        for (int i = 1; i < n; i++) {
            if (groups[i] != lastGroup) {
                result.add(words[i]);
                lastGroup = groups[i];
            }
        }

        return result;
    }
}
