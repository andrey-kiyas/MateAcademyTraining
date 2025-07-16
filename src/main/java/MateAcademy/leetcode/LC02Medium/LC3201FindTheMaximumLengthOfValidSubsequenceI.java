package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i
 */

public class LC3201FindTheMaximumLengthOfValidSubsequenceI {
    public static void main(String[] args) {
        System.out.println(maximumLength(new int[]{1, 2, 3, 4}));           // 4
        System.out.println(maximumLength(new int[]{1, 2, 1, 1, 2, 1, 2}));  // 6
        System.out.println(maximumLength(new int[]{1, 3}));                 // 2
    }

    public static int maximumLength(int[] nums) {
        int k = 2;
        int[][] frequency = new int[k][k];
        int maxLength = 0;

        for (int num : nums) {
            num %= k;
            for (int j = 0; j < k; ++j) {
                int y = (j - num + k) % k;
                frequency[num][y] = frequency[y][num] + 1;
                maxLength = Math.max(maxLength, frequency[num][y]);
            }
        }
        return maxLength;
    }
}
