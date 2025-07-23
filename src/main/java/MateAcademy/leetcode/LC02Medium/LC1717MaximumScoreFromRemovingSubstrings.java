package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/maximum-score-from-removing-substrings
 */

public class LC1717MaximumScoreFromRemovingSubstrings {
    public static void main(String[] args) {
        System.out.println(maximumGain("cdbcbbaaabab", 4, 5));     // 19
        System.out.println(maximumGain("aabbaaxybbaabb", 5, 4));   // 20
    }

    public static int maximumGain(String s, int x, int y) {
        if (x > y) {
            return calculateGain(s, "ab", x, y);
        } else {
            return calculateGain(s, "ba", y, x);
        }
    }

    private static int calculateGain(String s, String firstPair, int firstScore, int secondScore) {
        StringBuilder sb = new StringBuilder();
        int score = 0;

        for (char c : s.toCharArray()) {
            sb.append(c);
            int len = sb.length();
            if (len >= 2 && sb.charAt(len - 2) == firstPair.charAt(0) && sb.charAt(len - 1) == firstPair.charAt(1)) {
                sb.delete(sb.length() - 2, sb.length());
                score += firstScore;
            }
        }

        String remaining = sb.toString();
        sb.setLength(0);

        char c1 = firstPair.charAt(1);
        char c2 = firstPair.charAt(0);

        for (char c : remaining.toCharArray()) {
            sb.append(c);
            int len = sb.length();
            if (len >= 2 && sb.charAt(len - 2) == c1 && sb.charAt(len - 1) == c2) {
                sb.delete(sb.length() - 2, sb.length());
                score += secondScore;
            }
        }

        return score;
    }
}
