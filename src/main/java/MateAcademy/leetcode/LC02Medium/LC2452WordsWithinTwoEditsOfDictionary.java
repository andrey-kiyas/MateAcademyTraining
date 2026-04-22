package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/words-within-two-edits-of-dictionary
 */

public class LC2452WordsWithinTwoEditsOfDictionary {
    public static void main(String[] args) {
        String[] q1 = {"word", "note", "ants", "wood"};
        String[] d1 = {"wood", "joke", "moat"};
        System.out.println(twoEditWords(q1, d1)); // [word, note, wood]

        String[] q2 = {"yes"};
        String[] d2 = {"not"};
        System.out.println(twoEditWords(q2, d2)); // []
    }

    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for (String query : queries) {
            for (String word : dictionary) {
                if (canMatch(query, word)) {
                    result.add(query);
                    break;
                }
            }
        }

        return result;
    }

    private static boolean canMatch(String q, String d) {
        int edits = 0;
        int n = q.length();

        for (int i = 0; i < n; i++) {
            if (q.charAt(i) != d.charAt(i)) {
                edits++;
            }
            if (edits > 2) {
                return false;
            }
        }

        return true;
    }
}
