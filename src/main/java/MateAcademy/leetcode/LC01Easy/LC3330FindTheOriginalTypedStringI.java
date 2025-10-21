package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/find-the-original-typed-string-i
 */

public class LC3330FindTheOriginalTypedStringI {
    public static void main(String[] args) {
        String hello = "HelloWorld!";
        System.out.println(hello.substring(2, 7));

//        System.out.println(possibleStringCount("abbcccc")); // 5
//        System.out.println(possibleStringCount("abcd"));    // 1
//        System.out.println(possibleStringCount("aaaa"));    // 4
    }

    public static int possibleStringCount(String word) {
        int count = 1;
        int n = word.length();
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                count++;
            }
        }
        return count;
    }
}
