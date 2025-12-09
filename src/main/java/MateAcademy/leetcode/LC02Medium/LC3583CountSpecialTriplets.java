package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/count-special-triplets/description
 */

public class LC3583CountSpecialTriplets {
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(specialTriplets(new int[]{6, 3, 6}));           // 1
        System.out.println(specialTriplets(new int[]{0, 1, 0, 0}));        // 1
        System.out.println(specialTriplets(new int[]{8, 4, 2, 8, 4}));     // 2
    }

    public static int specialTriplets(int[] nums) {
        int n = nums.length;
        int max = 100000;

        long[] left = new long[max * 2 + 1];
        long[] right = new long[max * 2 + 1];

        for (int num : nums) {
            right[num]++;
        }

        long ans = 0;

        for (int j = 0; j < n; j++) {
            int x = nums[j];
            right[x]--;

            int twice = x * 2;
            if (twice <= max * 2) {
                long cntLeft = left[twice];
                long cntRight = right[twice];
                ans = (ans + cntLeft * cntRight) % MOD;
            }

            left[x]++;
        }

        return (int) ans;
    }
}
