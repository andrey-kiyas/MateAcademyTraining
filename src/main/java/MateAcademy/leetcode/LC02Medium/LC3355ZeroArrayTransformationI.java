package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/zero-array-transformation-i
 */

public class LC3355ZeroArrayTransformationI {
    public static void main(String[] args) {
        System.out.println(isZeroArray(new int[]{1, 0, 1}, new int[][]{{0, 2}}));            // true
        System.out.println(isZeroArray(new int[]{4, 3, 2, 1}, new int[][]{{1, 3}, {0, 2}})); // false
    }

    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] differenceArray = new int[n + 1];

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            ++differenceArray[left];
            --differenceArray[right + 1];
        }

        int currentSum = 0;
        for (int i = 0; i < n; ++i) {
            currentSum += differenceArray[i];

            if (nums[i] > currentSum) {
                return false;
            }
        }

        return true;
    }
}
