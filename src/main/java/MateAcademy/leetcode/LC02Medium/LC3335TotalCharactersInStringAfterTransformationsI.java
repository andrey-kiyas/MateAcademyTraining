package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/total-characters-in-string-after-transformations-i
 */

public class LC3335TotalCharactersInStringAfterTransformationsI {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(lengthAfterTransformations("abcyy", 2)); // 7
        System.out.println(lengthAfterTransformations("azbk", 1));  // 5
        System.out.println(lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517));  // 79033769

    }

    public static int lengthAfterTransformations(String s, int t) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        while (t-- > 0) {
            int[] next = new int[26];
            for (int j = 0; j < 26; j++) {
                if (j < 25) {
                    next[j + 1] = freq[j];
                } else {
                    next[0] = (next[0] + freq[25]) % MOD;
                    next[1] = (next[1] + freq[25]) % MOD;
                }
            }
            freq = next;
        }

        int result = 0;
        for (int x : freq) {
            result = (result + x) % MOD;
        }
        return result;
    }
}
