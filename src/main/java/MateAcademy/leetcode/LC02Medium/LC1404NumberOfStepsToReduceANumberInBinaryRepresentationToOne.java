package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one
 */

public class LC1404NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    public static void main(String[] args) {
        System.out.println(numSteps("1101")); // 6
        System.out.println(numSteps("10"));   // 1
        System.out.println(numSteps("1"));    // 0
    }

    public static int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            int digit = s.charAt(i) - '0';

            if (digit + carry == 1) {
                steps += 2;
                carry = 1;
            } else {
                steps += 1;
            }
        }

        return steps + carry;
    }
}
