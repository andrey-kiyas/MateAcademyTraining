package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-balanced-substring-ii
 */

public class LC3714LongestBalancedSubstringII {
    public static void main(String[] args) {
        System.out.println(longestBalanced("abbac")); // 4
        System.out.println(longestBalanced("aabcc")); // 3
        System.out.println(longestBalanced("aba"));   // 2
    }

    public static int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        int currentRun = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                currentRun++;
            } else {
                currentRun = 1;
            }
            maxLen = Math.max(maxLen, currentRun);
        }

        maxLen = Math.max(maxLen, checkPair(s, 'a', 'b', 'c'));
        maxLen = Math.max(maxLen, checkPair(s, 'b', 'c', 'a'));
        maxLen = Math.max(maxLen, checkPair(s, 'a', 'c', 'b'));

        maxLen = Math.max(maxLen, checkTrio(s));

        return maxLen;
    }

    private static int checkPair(String s, char x, char y, char z) {
        int n = s.length();
        int max = 0;
        String[] segments = s.split(String.valueOf(z));

        for (String seg : segments) {
            if (seg.isEmpty()) continue;
            int[] firstOccur = new int[2 * seg.length() + 1];
            Arrays.fill(firstOccur, -2);
            int diff = 0;
            firstOccur[seg.length()] = -1;

            for (int i = 0; i < seg.length(); i++) {
                if (seg.charAt(i) == x) diff++;
                else if (seg.charAt(i) == y) diff--;

                int pos = diff + seg.length();
                if (firstOccur[pos] != -2) {
                    max = Math.max(max, i - firstOccur[pos]);
                } else {
                    firstOccur[pos] = i;
                }
            }
        }
        return max;
    }

    private static int checkTrio(String s) {
        int n = s.length();
        Map<Long, Integer> map = new HashMap<>();
        int ca = 0, cb = 0, cc = 0;
        map.put(0L, -1);
        int max = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'a') ca++;
            else if (c == 'b') cb++;
            else if (c == 'c') cc++;

            long key = (((long)(ca - cb)) << 32) | ((cb - cc) & 0xFFFFFFFFL);
            if (map.containsKey(key)) {
                max = Math.max(max, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }
        return max;
    }
}
