package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon
 */

public class LC3147TakingMaximumEnergyFromTheMysticDungeon {
    public static void main(String[] args) {
        System.out.println(maximumEnergy(new int[]{5, 2, -10, -5, 1}, 3)); // 3
        System.out.println(maximumEnergy(new int[]{-2, -3, -1}, 2));      // -1
    }

    public static int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (i + k < n) {
                dp[i] = energy[i] + dp[i + k];
            } else {
                dp[i] = energy[i];
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
