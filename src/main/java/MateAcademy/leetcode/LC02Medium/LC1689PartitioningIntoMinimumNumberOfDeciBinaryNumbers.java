package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers
 */

public class LC1689PartitioningIntoMinimumNumberOfDeciBinaryNumbers {
    public static void main(String[] args) {
            System.out.println(minPartitions("32"));                   // 3
            System.out.println(minPartitions("82734"));                // 8
            System.out.println(minPartitions("27346209830709182346")); // 9
    }

    public static int minPartitions(String n) {
        int maxDigit = 0;

        for (int i = 0; i < n.length(); i++) {
            int currentDigit = n.charAt(i) - '0';

            if (currentDigit == 9) return 9;

            if (currentDigit > maxDigit) {
                maxDigit = currentDigit;
            }
        }

        return maxDigit;
    }
}
