package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/count-the-hidden-sequences
 */

public class LC2145CountTheHiddenSequences {
    public static void main(String[] args) {
        System.out.println(numberOfArrays(new int[]{1, -3, 4}, 1, 6));         // 2
        System.out.println(numberOfArrays(new int[]{3, -4, 5, 1, -2}, -4, 5)); // 4
        System.out.println(numberOfArrays(new int[]{4, -7, 2}, 3, 6));         // 0
    }

    public static int numberOfArrays(int[] differences, int lower, int upper) {
        long minPrefix = 0, maxPrefix = 0, curr = 0;

        for (int diff : differences) {
            curr += diff;
            minPrefix = Math.min(minPrefix, curr);
            maxPrefix = Math.max(maxPrefix, curr);
        }

        long minStart = lower - minPrefix;
        long maxStart = upper - maxPrefix;

        return (int)Math.max(0, maxStart - minStart + 1);
    }
}
