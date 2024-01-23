package MateAcademy.leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/stickers-to-spell-word
 */

public class StickersToSpellWord691 {

    public static void main(String[] args) {
        String[] stickers1 = {"with", "example", "science"};
        String target1 = "thehat";
        System.out.println(minStickers(stickers1, target1)); // Output: 3

        String[] stickers2 = {"notice", "possible"};
        String target2 = "basicbasic";
        System.out.println(minStickers(stickers2, target2)); // Output: -1

        String[] stickers = {"summer", "sky", "cent", "bright", "kill", "forest", "neighbor", "capital", "tall"};
        String target = "originalchair";
        System.out.println(minStickers(stickers, target)); // Output: 3
    }

    public static int minStickers(String[] stickers, String target) {
        int[][] stickerCounts = new int[stickers.length][26];
        Map<String, Integer> memo = new HashMap<>();

        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerCounts[i][c - 'a']++;
            }
        }

        int result = dfs(stickerCounts, target, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int dfs(int[][] stickerCounts, String target, Map<String, Integer> memo) {
        if (target.isEmpty()) {
            return 0;
        }
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        int[] targetCounts = new int[26];
        for (char c : target.toCharArray()) {
            targetCounts[c - 'a']++;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < stickerCounts.length; i++) {
            if (stickerCounts[i][target.charAt(0) - 'a'] > 0) {
                StringBuilder newTarget = new StringBuilder();
                for (int j = 0; j < 26; j++) {
                    if (targetCounts[j] > stickerCounts[i][j]) {
                        for (int k = 0; k < targetCounts[j] - stickerCounts[i][j]; k++) {
                            newTarget.append((char) ('a' + j));
                        }
                    }
                }
                int subResult = dfs(stickerCounts, newTarget.toString(), memo);
                if (subResult != Integer.MAX_VALUE) {
                    result = Math.min(result, 1 + subResult);
                }
            }
        }
        memo.put(target, result);
        return result;
    }

    public static int minStickers3(String[] stickers, String target) {
        int n = target.length();
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int state = 0; state < (1 << n); state++) {
            if (dp[state] == Integer.MAX_VALUE) continue;
            for (String sticker : stickers) {
                int nextState = state;

                for (char c : sticker.toCharArray()) {
                    for (int i = 0; i < n; i++) {
                        if (((state >> i) & 1) == 0 && target.charAt(i) == c) {
                            nextState |= (1 << i);
                            break;
                        }
                    }
                }
                dp[nextState] = Math.min(dp[nextState], dp[state] + 1);
            }
        }
        return dp[(1 << n) - 1] == Integer.MAX_VALUE ? -1 : dp[(1 << n) - 1];
    }

    public static int minStickers2(String[] stickers, String target) {
        int n = target.length();
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        for (int state = 0; state < (1 << n); state++) {
            if (dp[state] == -1) continue;
            for (String sticker : stickers) {
                int nextState = state;
                for (char c : sticker.toCharArray()) {
                    for (int i = 0; i < n; i++) {
                        if (((state >> i) & 1) == 0 && target.charAt(i) == c) {
                            nextState |= (1 << i);
                            break;
                        }
                    }
                }
                if (dp[nextState] == -1 || dp[nextState] > dp[state] + 1) {
                    dp[nextState] = dp[state] + 1;
                }
            }
        }
        return dp[(1 << n) - 1];
    }

    public static int minStickers1(String[] stickers, String target) {
        int n = target.length();
        int[] dp = new int[1 << n];
        for (int i = 1; i < (1 << n); i++) {
            dp[i] = -1;
        }
        for (int state = 0; state < (1 << n); state++) {
            if (dp[state] == -1) continue;
            for (String sticker : stickers) {
                int nextState = state;
                for (char c : sticker.toCharArray()) {
                    for (int i = 0; i < n; i++) {
                        if (((state >> i) & 1) == 0 && target.charAt(i) == c) {
                            nextState |= (1 << i);
                            break;
                        }
                    }
                }
                if (dp[nextState] == -1 || dp[nextState] > dp[state] + 1) {
                    dp[nextState] = dp[state] + 1;
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}
