package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away
 */

public class LC1437CheckIfAll1SAreAtLeastLengthKPlacesAway {
    public static void main(String[] args) {
        System.out.println(kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2)); // true
        System.out.println(kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2));       // false
    }

    public static boolean kLengthApart(int[] nums, int k) {
        int prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prev != -1 && i - prev - 1 < k) {
                    return false;
                }
                prev = i;
            }
        }
        return true;
    }
}
