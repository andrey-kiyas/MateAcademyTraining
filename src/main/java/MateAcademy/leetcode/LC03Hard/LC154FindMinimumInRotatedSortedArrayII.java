package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii
 */

public class LC154FindMinimumInRotatedSortedArrayII {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1, 3, 5}));       // 1
        System.out.println(findMin(new int[]{2, 2, 2, 0, 1})); // 0
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }

        return nums[left];
    }
}
