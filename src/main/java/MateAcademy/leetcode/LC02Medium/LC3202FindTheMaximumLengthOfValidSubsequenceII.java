package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-ii
 */

public class LC3202FindTheMaximumLengthOfValidSubsequenceII {
    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{1, 2, 3, 4, 5}, 2));       // 5
        System.out.println(maximumLength(new int[]{1, 4, 2, 3, 1, 4}, 3));    // 4
    }

    public static int maximumLength(int[] nums, int k) {
        int[][] subarrayLengths = new int[k][k];
        int maxLength = 0;

        for (int num : nums) {
            int modValue = num % k;

            for (int j = 0; j < k; ++j) {
                int requiredMod = (j - modValue + k) % k;

                subarrayLengths[modValue][requiredMod] = subarrayLengths[requiredMod][modValue] + 1;

                maxLength = Math.max(maxLength, subarrayLengths[modValue][requiredMod]);
            }
        }
        return maxLength;
    }
}
