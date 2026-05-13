package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/minimum-moves-to-make-array-complementary
 */

public class LC1674MinimumMovesToMakeArrayComplementary {
    public static void main(String[] args) {
        System.out.println(minMoves(new int[]{1, 2, 4, 3}, 4)); // 1
        System.out.println(minMoves(new int[]{1, 2, 2, 1}, 2)); // 2
        System.out.println(minMoves(new int[]{1, 2, 1, 2}, 2)); // 0
    }

    public static int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];

            diff[2] += 2;
            diff[2 * limit + 1] -= 2;

            int minSum = Math.min(a, b) + 1;
            int maxSum = Math.max(a, b) + limit;
            diff[minSum] -= 1;
            diff[maxSum + 1] += 1;

            int currentSum = a + b;
            diff[currentSum] -= 1;
            diff[currentSum + 1] += 1;
        }

        int minMoves = n;
        int currentMoves = 0;
        for (int t = 2; t <= 2 * limit; t++) {
            currentMoves += diff[t];
            minMoves = Math.min(minMoves, currentMoves);
        }

        return minMoves;
    }
}
