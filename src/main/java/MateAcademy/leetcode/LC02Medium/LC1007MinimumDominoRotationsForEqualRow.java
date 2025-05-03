package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row
 */

public class LC1007MinimumDominoRotationsForEqualRow {
    public static void main(String[] args) {
        System.out.println(minDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2})); // 2
        System.out.println(minDominoRotations(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}));     // -1
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int rotations = check(tops[0], tops, bottoms);
        if (rotations != -1 || tops[0] == bottoms[0]) {
            return rotations;
        }
        return check(bottoms[0], tops, bottoms);
    }

    private static int check(int target, int[] tops, int[] bottoms) {
        int topRotations = 0, bottomRotations = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            } else if (tops[i] != target) {
                topRotations++;
            } else if (bottoms[i] != target) {
                bottomRotations++;
            }
        }

        return Math.min(topRotations, bottomRotations);
    }
}
