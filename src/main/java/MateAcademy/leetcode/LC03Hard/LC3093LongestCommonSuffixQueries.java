package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-common-suffix-queries
 */

public class LC3093LongestCommonSuffixQueries {
    public static void main(String[] args) {
        String[] container1 = {"abcd", "bcd", "xbcd"};
        String[] query1 = {"cd", "bcd", "xyz"};
        System.out.println(Arrays.toString(stringIndices(container1, query1))); // [1, 1, 1]

        String[] container2 = {"abcdefgh", "poiuygh", "ghghgh"};
        String[] query2 = {"gh", "acbfgh", "acbfegh"};
        System.out.println(Arrays.toString(stringIndices(container2, query2))); // [2, 0, 2]
    }

    public static int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();

        int defaultIndex = 0;
        for (int i = 1; i < wordsContainer.length; i++) {
            if (wordsContainer[i].length() < wordsContainer[defaultIndex].length()) {
                defaultIndex = i;
            }
        }
        root.minIndex = defaultIndex;

        for (int i = 0; i < wordsContainer.length; i++) {
            String word = wordsContainer[i];
            TrieNode curr = root;

            for (int j = word.length() - 1; j >= 0; j--) {
                int charIdx = word.charAt(j) - 'a';
                if (curr.children[charIdx] == null) {
                    curr.children[charIdx] = new TrieNode();
                }
                curr = curr.children[charIdx];

                if (curr.minIndex == -1) {
                    curr.minIndex = i;
                } else {
                    int existingLen = wordsContainer[curr.minIndex].length();
                    int currentLen = word.length();
                    if (currentLen < existingLen) {
                        curr.minIndex = i;
                    }
                }
            }
        }

        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            String query = wordsQuery[i];
            TrieNode curr = root;

            for (int j = query.length() - 1; j >= 0; j--) {
                int charIdx = query.charAt(j) - 'a';
                if (curr.children[charIdx] == null) {
                    break;
                }
                curr = curr.children[charIdx];
            }
            ans[i] = curr.minIndex;
        }

        return ans;
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int minIndex = -1;
    }
}

