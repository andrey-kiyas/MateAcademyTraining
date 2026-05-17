package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/jump-game-iii
 */

public class LC1306JumpGameIII {
    public static void main(String[] args) {
        System.out.println(canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5)); // true
        System.out.println(canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 0)); // true
        System.out.println(canReach(new int[]{3, 0, 2, 1, 2}, 2));       // false
    }

    public static boolean canReach(int[] arr, int start) {
        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }

        if (arr[start] == 0) {
            return true;
        }

        int step = arr[start];

        arr[start] = -arr[start];

        return canReach(arr, start + step) || canReach(arr, start - step);
    }
}
