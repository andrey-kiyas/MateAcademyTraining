package MateAcademy.code_test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Groups {
    public static void main(String[] args) {
        System.out.println(isValid2("{[]}")); // ==> true
        System.out.println(isValid2("[(](")); // ==> false
        System.out.println(isValid2("{}()[")); // ==> false
    }

    public static boolean isValid2(String string) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ']') {
                if (stack.empty() || !stack.peek().equals('[')) {
                    return false;
                }
                stack.pop();
            } else if (string.charAt(i) == ')') {
                if (stack.empty() || !stack.peek().equals('(')) {
                    return false;
                }
                stack.pop();
            } else if (string.charAt(i) == '}') {
                if (stack.empty() || !stack.peek().equals('{')) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(string.charAt(i));
            }
        }
        return stack.empty();
    }

    public static boolean isValid(String string) {
        // write code here
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        Deque<Character> stack = new LinkedList<>();
        for (char ch : string.toCharArray()) {
            if (brackets.containsValue(ch)) {
                stack.push(ch);
            } else if (brackets.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != brackets.get(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
