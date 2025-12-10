package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/count-the-number-of-computer-unlocking-permutations
 */

public class LC3577CountTheNumberOfComputerUnlockingPermutations {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        int[] c1 = {1, 2, 3};
        int[] c2 = {3, 3, 3, 4, 4, 4};

        System.out.println(countPermutations(c1)); //  2
        System.out.println(countPermutations(c2)); //  0
    }

    public static int countPermutations(int[] complexity) {
        long result = 1;

        for (int i = 1; i < complexity.length; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }

            result = (result * i) % MOD;
        }

        return (int) result;
    }
}
