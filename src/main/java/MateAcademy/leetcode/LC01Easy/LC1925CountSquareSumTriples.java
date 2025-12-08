package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/count-square-sum-triples
 */

public class LC1925CountSquareSumTriples {
    public static void main(String[] args) {
        System.out.println(countTriples(5));  // 2
        System.out.println(countTriples(10)); // 4
    }

    public static int countTriples(int n) {
        int count = 0;

        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {

                int c2 = a * a + b * b;
                int c = (int) Math.sqrt(c2);

                if (c <= n && c * c == c2) {
                    count++;
                }
            }
        }

        return count;
    }
}
