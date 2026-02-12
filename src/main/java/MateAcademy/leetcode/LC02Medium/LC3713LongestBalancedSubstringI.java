package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/longest-balanced-substring-i
 */

public class LC3713LongestBalancedSubstringI {
    public static void main(String[] args) {
        System.out.println(longestBalanced("abbac"));   // 4
        System.out.println(longestBalanced("zzabccy")); // 4
        System.out.println(longestBalanced("aba"));     // 2
    }

    public static int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] counts = new int[26];

            for (int j = i; j < n; j++) {
                counts[s.charAt(j) - 'a']++;

                if (isBalanced(counts)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private static boolean isBalanced(int[] counts) {
        int commonFreq = -1;

        for (int count : counts) {
            if (count > 0) {
                if (commonFreq == -1) {
                    commonFreq = count;
                } else if (count != commonFreq) {
                    return false;
                }
            }
        }

        return commonFreq != -1;
    }
}
