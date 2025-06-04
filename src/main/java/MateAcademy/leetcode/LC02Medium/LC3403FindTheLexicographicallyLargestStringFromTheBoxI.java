package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i
 */

public class LC3403FindTheLexicographicallyLargestStringFromTheBoxI {
    public static void main(String[] args) {
        System.out.println(answerString("dbca", 2)); // "dbc"
        System.out.println(answerString("gggg", 4)); // "g"
        System.out.println(answerString("gh", 1));   // "gh"
        System.out.println(answerString("aann", 2)); // "nn"
        System.out.println(
                answerString("cgwzebexlahnfqsetbeaybmfdzywpvehjybpwiotnciddjonfi",
                        21));                              // "zywpvehjybpwiotnciddjonfi"
    }

    public static String answerString(String word, int numFriends) {
        if (numFriends == 1)
            return word;
        final String s = lastSubstring(word);
        final int sz = word.length() - numFriends + 1;
        return s.substring(0, Math.min(s.length(), sz));
    }

    private static String lastSubstring(String s) {
        int i = 0;
        int j = 1;
        int k = 0;

        while (j + k < s.length())
            if (s.charAt(i + k) == s.charAt(j + k)) {
                ++k;
            } else if (s.charAt(i + k) > s.charAt(j + k)) {
                j = j + k + 1;
                k = 0;
            } else {
                i = Math.max(i + k + 1, j);
                j = i + 1;
                k = 0;
            }

        return s.substring(i);
    }
}
