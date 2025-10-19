package MateAcademy.leetcode.LC02Medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations
 */

public class LC1625LexicographicallySmallestStringAfterApplyingOperations {
    public static void main(String[] args) {
        System.out.println(findLexSmallestString("5525", 9, 2)); // "2050"
        System.out.println(findLexSmallestString("74", 5, 1));   // "24"
        System.out.println(findLexSmallestString("0011", 4, 2)); // "0011"
    }

    public static String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        String min = s;
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (cur.compareTo(min) < 0) {
                min = cur;
            }

            String added = addOperation(cur, a);

            String rotated = rotateOperation(cur, b);

            if (visited.add(added)) queue.add(added);
            if (visited.add(rotated)) queue.add(rotated);
        }
        return min;
    }

    private static String addOperation(String s, int a) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            int digit = (arr[i] - '0' + a) % 10;
            arr[i] = (char) ('0' + digit);
        }
        return new String(arr);
    }

    private static String rotateOperation(String s, int b) {
        int n = s.length();
        b %= n;
        return s.substring(n - b) + s.substring(0, n - b);
    }
}
