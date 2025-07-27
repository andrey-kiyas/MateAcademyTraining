package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/count-hills-and-valleys-in-an-array
 */

public class LC2210CountHillsAndValleysInAnArray {
    public static void main(String[] args) {
        int[] nums1 = {2, 4, 1, 1, 6, 5};
        int[] nums2 = {6, 6, 5, 5, 4, 1};
        System.out.println(countHillValley(nums1)); // 3
        System.out.println(countHillValley(nums2)); // 0
    }

    public static int countHillValley(int[] nums) {
        int count = 0;

        for (int currentIndex = 1, previousIndex = 0; currentIndex < nums.length - 1; ++currentIndex) {
            if (nums[currentIndex] == nums[currentIndex + 1]) {
                continue;
            }
            if (nums[currentIndex] > nums[previousIndex] && nums[currentIndex] > nums[currentIndex + 1]) {
                count++;
            }
            if (nums[currentIndex] < nums[previousIndex] && nums[currentIndex] < nums[currentIndex + 1]) {
                count++;
            }
            previousIndex = currentIndex;
        }

        return count;
    }
}
