package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/score-of-a-string
 */

public class LC3110ScoreOfAString {

    public static void main(String[] args) {
        System.out.println(scoreOfString("hello"));
    }

    public static int scoreOfString(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            result += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return result;
    }
}
