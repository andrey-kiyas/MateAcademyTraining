package MateAcademy.leetcode.LC02Medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters
 */

public class LC1081SmallestSubsequenceOfDistinctCharacters {
    public static void main(String[] args) {
        System.out.println(smallestSubsequence("bcabc"));    // "abc"
        System.out.println(smallestSubsequence("cbacdcbc")); // "acdb"
    }

    public static String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] seen = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen[c - 'a']) continue;

            while (!stack.isEmpty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            seen[c - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }
}
