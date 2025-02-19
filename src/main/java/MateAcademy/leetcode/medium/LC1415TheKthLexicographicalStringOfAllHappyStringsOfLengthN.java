package MateAcademy.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n
 */

public class LC1415TheKthLexicographicalStringOfAllHappyStringsOfLengthN {
    public static void main(String[] args) {
        System.out.println(getHappyString(1, 3)); // "c"
        System.out.println(getHappyString(1, 4)); // ""
        System.out.println(getHappyString(3, 9)); // "cab"
    }

    public static String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        generateHappyStrings(n, "", happyStrings);

        return k <= happyStrings.size() ? happyStrings.get(k - 1) : "";
    }

    private static void generateHappyStrings(int n, String current, List<String> happyStrings) {
        if (current.length() == n) {
            happyStrings.add(current);
            return;
        }
        for (char c : new char[]{'a', 'b', 'c'}) {
            if (current.isEmpty() || current.charAt(current.length() - 1) != c) {
                generateHappyStrings(n, current + c, happyStrings);
            }
        }
    }
}
