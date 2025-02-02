package MateAcademy.leetcode.easy;

/**
 * https://leetcode.com/problems/special-array-i/
 */

public class LC3151SpecialArrayI {

    public static void main(String[] args) {
        System.out.println(isArraySpecial(new int[]{1}));
        System.out.println(isArraySpecial(new int[]{2, 1, 4}));
        System.out.println(isArraySpecial(new int[]{4, 3, 1, 6}));
    }

    public static boolean isArraySpecial(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] % 2) == (nums[i - 1] % 2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isArraySpecial2(int[] nums) {
        if (nums.length > 1) {

            boolean even = nums[0] % 2 == 0;
            boolean curr = false;

            for (int i = 1; i < nums.length; i++) {
                curr = nums[i] % 2 == 0;
                if (even == curr) {
                    return false;
                }
                even = curr;
            }
        }
        return true;
    }
}
