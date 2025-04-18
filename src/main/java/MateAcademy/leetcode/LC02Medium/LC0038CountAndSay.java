package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/count-and-say
 */

public class LC0038CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(1));  // 1
        System.out.println(countAndSay(4));  // 1211
    }

    public static String countAndSay(int n) {
        if (n == 1) return "1";

        String result = "1";
        for (int i = 2; i <= n; i++) {
            result = say(result);
        }
        return result;
    }

    private static String say(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char prev = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == prev) {
                count++;
            } else {
                sb.append(count).append(prev);
                count = 1;
                prev = curr;
            }
        }
        sb.append(count).append(prev);
        return sb.toString();
    }
}
