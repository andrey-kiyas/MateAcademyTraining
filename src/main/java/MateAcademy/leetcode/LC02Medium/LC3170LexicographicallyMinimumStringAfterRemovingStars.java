package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/description
 */

public class LC3170LexicographicallyMinimumStringAfterRemovingStars {
    public static void main(String[] args) {
        System.out.println(clearStars("aaba*"));  // Output: "aab"
        System.out.println(clearStars("abc"));    // Output: "abc"
        System.out.println(clearStars("cb*a*"));  // Output: "c"
    }

    public static String clearStars(String s) {
        List<List<Integer>> charPos = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            charPos.add(new ArrayList<>());
        }

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '*') {
                for (int j = 0; j < 26; j++) {
                    if (!charPos.get(j).isEmpty()) {
                        int pos = charPos.get(j).remove(charPos.get(j).size() - 1);
                        arr[pos] = '*';
                        break;
                    }
                }
            } else {
                charPos.get(arr[i] - 'a').add(i);
            }
        }

        StringBuilder res = new StringBuilder();
        for (char c : arr) {
            if (c != '*') {
                res.append(c);
            }
        }

        return res.toString();
    }
}
