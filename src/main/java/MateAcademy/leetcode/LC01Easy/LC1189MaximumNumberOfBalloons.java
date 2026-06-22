package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/maximum-number-of-balloons
 */

public class LC1189MaximumNumberOfBalloons {
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("nlaebolko"));        // 1
        System.out.println(maxNumberOfBalloons("loonbalxballpoon")); // 2
        System.out.println(maxNumberOfBalloons("leetcode"));         // 0
    }

    public static int maxNumberOfBalloons(String text) {
        int b = 0, a = 0, l = 0, o = 0, n = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == 'b') b++;
            else if (ch == 'a') a++;
            else if (ch == 'l') l++;
            else if (ch == 'o') o++;
            else if (ch == 'n') n++;
        }

        l = l / 2;
        o = o / 2;

        return Math.min(b, Math.min(a, Math.min(l, Math.min(o, n))));
    }
}
