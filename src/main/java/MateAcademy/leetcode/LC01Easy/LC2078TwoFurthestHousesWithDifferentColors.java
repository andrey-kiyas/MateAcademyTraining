package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/two-furthest-houses-with-different-colors
 */

public class LC2078TwoFurthestHousesWithDifferentColors {
    public static void main(String[] args) {
            System.out.println(maxDistance(new int[]{1, 1, 1, 6, 1, 1, 1})); // 3
            System.out.println(maxDistance(new int[]{1, 8, 3, 8, 3}));       // 4
            System.out.println(maxDistance(new int[]{0, 1}));                // 1
    }

    public static int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;

        for (int i = n - 1; i > 0; i--) {
            if (colors[i] != colors[0]) {
                maxDist = i;
                break;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (colors[i] != colors[n - 1]) {
                maxDist = Math.max(maxDist, (n - 1) - i);
                break;
            }
        }

        return maxDist;
    }
}
