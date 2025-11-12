package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1
 */

public class LC2654MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1 {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2, 6, 3, 4}));   // 4
        System.out.println(minOperations(new int[]{2, 10, 6, 14})); // -1
    }

    public static int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;
        for (int x : nums) {
            if (x == 1) ones++;
        }

        if (ones > 0) {
            return n - ones;
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        if (minLen == Integer.MAX_VALUE) return -1;

        return (minLen - 1) + (n - 1);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
