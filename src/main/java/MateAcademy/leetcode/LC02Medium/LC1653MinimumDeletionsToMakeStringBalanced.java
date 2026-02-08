package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/minimum-deletions-to-make-string-balanced
 */

public class LC1653MinimumDeletionsToMakeStringBalanced {
    public static void main(String[] args) {
        System.out.println(minimumDeletions("aababbab"));  // 2
        System.out.println(minimumDeletions("bbaaaaabb")); // 2
    }

    public static int minimumDeletions(String s) {
        int countB = 0;
        int deletions = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'b') {
                countB++;
            } else {
                if (countB > 0) {
                    deletions++;
                    countB--;
                }
            }
        }

        return deletions;
    }
}
