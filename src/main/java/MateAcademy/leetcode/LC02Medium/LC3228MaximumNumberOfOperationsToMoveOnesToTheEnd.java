package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/maximum-number-of-operations-to-move-ones-to-the-end
 */

public class LC3228MaximumNumberOfOperationsToMoveOnesToTheEnd {
    public static void main(String[] args) {
        System.out.println(maxOperations("1001101")); // 4
        System.out.println(maxOperations("00111"));   // 0
    }

    public static int maxOperations(String s) {
        long totalOperations = 0;
        int currentOnes = 0;

        boolean inZerosBlock = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                currentOnes++;
                inZerosBlock = false;
            } else {
                if (currentOnes > 0 && !inZerosBlock) {
                    totalOperations += currentOnes;
                    inZerosBlock = true;
                }
            }
        }

        return (int) totalOperations;
    }
}
