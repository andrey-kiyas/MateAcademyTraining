package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii
 */

public class LC3307FindTheKThCharacterInStringGameII {
    public static void main(String[] args) {
        System.out.println(kthCharacter(5, new int[]{0, 0, 0}));       // Output: a
        System.out.println(kthCharacter(10, new int[]{0, 1, 0, 1}));   // Output: b
    }

    public static char kthCharacter(long k, int[] operations) {
        final int operationsCount = (int) Math.ceil(Math.log(k) / Math.log(2));
        int increases = 0;

        for (int i = operationsCount - 1; i >= 0; --i) {
            final long halfSize = 1L << i;
            if (k > halfSize) {
                k -= halfSize;
                increases += operations[i];
            }
        }

        return (char) ('a' + increases % 26);
    }
}
