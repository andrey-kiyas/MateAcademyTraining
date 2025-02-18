package MateAcademy.leetcode.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/construct-smallest-number-from-di-string
 */

public class LC2375ConstructSmallestNumberFromDIString {
    public static void main(String[] args) {
        System.out.println(smallestNumber("IIIDIDDD")); // 123549876
        System.out.println(smallestNumber("DDD"));      // 4321
    }

    public static String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= pattern.length(); i++) {
            stack.push(i + 1);
            if (i == pattern.length() || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }

        return result.toString();
    }
}
