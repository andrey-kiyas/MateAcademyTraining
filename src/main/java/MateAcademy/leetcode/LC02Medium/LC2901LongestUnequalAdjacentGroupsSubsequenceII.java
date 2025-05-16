package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii
 */

public class LC2901LongestUnequalAdjacentGroupsSubsequenceII {
    public static void main(String[] args) {
        String[] words1 = {"bab", "dab", "cab"};
        int[] groups1 = {1, 2, 2};
        System.out.println(getWordsInLongestSubsequence(words1, groups1)); // ["bab", "cab"] или ["bab", "dab"]

        String[] words2 = {"a", "b", "c", "d"};
        int[] groups2 = {1, 2, 3, 4};
        System.out.println(getWordsInLongestSubsequence(words2, groups2)); // ["a", "b", "c", "d"]
    }

    public static List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (groups[i] != groups[j] && words[i].length() == words[j].length() && hammingDistance(words[i], words[j]) == 1) {
                    graph[i].add(j);
                }
            }
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        int maxLen = 0, startIndex = 0;
        for (int i = 0; i < n; i++) {
            int length = dfs(i, graph, dp);
            if (length > maxLen) {
                maxLen = length;
                startIndex = i;
            }
        }

        List<String> result = new ArrayList<>();
        result.add(words[startIndex]);
        while (true) {
            boolean found = false;
            for (int neighbor : graph[startIndex]) {
                if (dp[neighbor] == dp[startIndex] - 1) {
                    result.add(words[neighbor]);
                    startIndex = neighbor;
                    found = true;
                    break;
                }
            }
            if (!found) break;
        }

        return result;
    }

    private static int dfs(int node, List<Integer>[] graph, int[] dp) {
        if (dp[node] != -1) return dp[node];
        int maxLength = 1;
        for (int neighbor : graph[node]) {
            maxLength = Math.max(maxLength, 1 + dfs(neighbor, graph, dp));
        }
        return dp[node] = maxLength;
    }

    private static int hammingDistance(String a, String b) {
        int dist = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) dist++;
        }
        return dist;
    }
}
