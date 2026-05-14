package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/check-if-array-is-good
 */

public class LC2784CheckIfArrayIsGood {
    public static void main(String[] args) {
        System.out.println(isGood(new int[]{2, 1, 3}));          // false
        System.out.println(isGood(new int[]{1, 3, 3, 2}));       // true
        System.out.println(isGood(new int[]{1, 1}));             // true
        System.out.println(isGood(new int[]{3, 4, 4, 1, 2, 1})); // false
    }

    public static boolean isGood(int[] nums) {
        int len = nums.length;
        if (len < 2) return false;

        int n = 0;
        for (int x : nums) {
            n = Math.max(n, x);
        }

        if (len != n + 1) {
            return false;
        }

        int[] counts = new int[n + 1];
        for (int x : nums) {
            if (x > n) return false;
            counts[x]++;
        }

        for (int i = 1; i < n; i++) {
            if (counts[i] != 1) return false;
        }

        return counts[n] == 2;
    }
}
