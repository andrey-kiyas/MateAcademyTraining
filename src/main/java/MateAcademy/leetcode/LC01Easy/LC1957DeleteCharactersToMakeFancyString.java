package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/delete-characters-to-make-fancy-string
 */

public class LC1957DeleteCharactersToMakeFancyString {
    public static void main(String[] args) {
        System.out.println(makeFancyString("leeetcode"));   // "leetcode"
        System.out.println(makeFancyString("aaabaaaa"));    // "aabaa"
        System.out.println(makeFancyString("aab"));         // "aab"
    }

    public static String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        sb.append(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count < 3) {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
