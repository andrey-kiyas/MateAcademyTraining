package MateAcademy.leetcode.LC02Medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string
 */

public class LC2434UsingARobotToPrintTheLexicographicallySmallestString {
    public static void main(String[] args) {
        System.out.println(robotWithString("zza"));  // Output: "azz"
        System.out.println(robotWithString("bac"));  // Output: "abc"
        System.out.println(robotWithString("bdda")); // Output: "addb"
    }

    public static String robotWithString(String s) {
        int n = s.length();
        char[] minSuffix = new char[n];
        minSuffix[n - 1] = s.charAt(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            minSuffix[i] = (char) Math.min(s.charAt(i), minSuffix[i + 1]);
        }

        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            stack.push(s.charAt(i));
            while (!stack.isEmpty() && (i == n - 1 || stack.peek() <= minSuffix[i + 1])) {
                result.append(stack.pop());
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
