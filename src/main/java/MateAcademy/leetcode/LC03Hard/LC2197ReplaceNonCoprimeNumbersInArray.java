package MateAcademy.leetcode.LC03Hard;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/replace-non-coprime-numbers-in-array
 */

public class LC2197ReplaceNonCoprimeNumbersInArray {
    public static void main(String[] args) {
        int[] nums1 = {6, 4, 3, 2, 7, 6, 2};
        int[] nums2 = {2, 2, 1, 1, 3, 3, 3};

        System.out.println(replaceNonCoprimes(nums1)); // [12, 7, 6]
        System.out.println(replaceNonCoprimes(nums2)); // [2, 1, 1, 3]
    }

    public static List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();

        for (int num : nums) {
            int current = num;

            while (!stack.isEmpty()) {
                int last = stack.getLast();
                int gcd = gcd(last, current);

                if (gcd > 1) {
                    current = lcm(last, current, gcd);
                    stack.removeLast();
                } else {
                    break;
                }
            }
            stack.add(current);
        }

        return stack;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private static int lcm(int a, int b, int gcd) {
        return (int)((long)a / gcd * b);
    }
}
