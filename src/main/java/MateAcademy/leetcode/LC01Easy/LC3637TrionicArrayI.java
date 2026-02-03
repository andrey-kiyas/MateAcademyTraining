package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/trionic-array-i
 */

public class LC3637TrionicArrayI {
    public static void main(String[] args) {
        System.out.println(isTrionic(new int[]{1, 3, 5, 4, 2, 6})); // true
        System.out.println(isTrionic(new int[]{2, 1, 3}));          // false
    }

    public static boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 4) return false;

        int i = 0;

        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1) return false;

        int p = i;

        while (i + 1 < n && nums[i] > nums[i + 1]) {
            i++;
        }
        if (i == p || i == n - 1) return false;

        int q = i;

        while (i + 1 < n && nums[i] < nums[i + 1]) {
            i++;
        }

        return i == n - 1;
    }
}
