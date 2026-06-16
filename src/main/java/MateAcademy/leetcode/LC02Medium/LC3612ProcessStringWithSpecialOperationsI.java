package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/process-string-with-special-operations-i
 */

public class LC3612ProcessStringWithSpecialOperationsI {
    public static void main(String[] args) {
        System.out.println(processStr("a#b%*")); // "ba"
        System.out.println(processStr("z*#"));   // ""
    }

    public static String processStr(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else if (ch == '#') {
                result.append(result.toString());
            } else if (ch == '%') {
                result.reverse();
            } else {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
