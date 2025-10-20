package MateAcademy.leetcode.LC01Easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/final-value-of-variable-after-performing-operations
 */

public class LC2011FinalValueOfVariableAfterPerformingOperations {
    public static void main(String[] args) {
        System.out.println(finalValueAfterOperations(new String[]{"--X", "X++", "X++"}));        // 1
        System.out.println(finalValueAfterOperations(new String[]{"++X", "++X", "X++"}));        // 3
        System.out.println(finalValueAfterOperations(new String[]{"X++", "++X", "--X", "X--"})); // 0

        System.out.println(finalValueAfterOperations2(new String[]{"--X", "X++", "X++"}));        // 1
        System.out.println(finalValueAfterOperations2(new String[]{"++X", "++X", "X++"}));        // 3
        System.out.println(finalValueAfterOperations2(new String[]{"X++", "++X", "--X", "X--"})); // 0
    }

    public static int finalValueAfterOperations(String[] operations) {
        return Arrays.stream(operations)
                .mapToInt(op -> op.charAt(1) == '+' ? 1 : -1)
                .sum();
    }

    public static int finalValueAfterOperations2(String[] operations) {
        int x = 0;
        for (String op : operations) {
            if (op.charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }
        return x;
    }
}
