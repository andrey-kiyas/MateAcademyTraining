package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/binary-gap
 */

public class LC0868BinaryGap {
    public static void main(String[] args) {
        System.out.println(binaryGap(22)); // 2 (10110 -> відстані 2 та 1)
        System.out.println(binaryGap(8));  // 0 (1000 -> лише одна 1)
        System.out.println(binaryGap(5));  // 2 (101 -> відстань 2)
    }

    public static int binaryGap(int n) {
        int lastPos = -1;
        int maxGap = 0;

        for (int i = 0; i < 31; i++) {
            if (((n >> i) & 1) == 1) {
                if (lastPos != -1) {
                    maxGap = Math.max(maxGap, i - lastPos);
                }
                lastPos = i;
            }
        }

        return maxGap;
    }
}
