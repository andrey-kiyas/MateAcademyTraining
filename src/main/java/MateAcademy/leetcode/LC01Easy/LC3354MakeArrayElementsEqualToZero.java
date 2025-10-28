package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/make-array-elements-equal-to-zero
 */

public class LC3354MakeArrayElementsEqualToZero {
    public static void main(String[] args) {
        int[] nums1 = {1, 0, 2, 0, 3};
        int[] nums2 = {2, 3, 4, 0, 4, 1, 0};
        System.out.println(countValidSelections(nums1)); // 2
        System.out.println(countValidSelections(nums2)); // 0
    }

    public static int countValidSelections(int[] nums) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (simulate(nums.clone(), i, -1)) count++;
                if (simulate(nums.clone(), i, 1)) count++;
            }
        }
        return count;
    }

    private static boolean simulate(int[] arr, int curr, int dir) {
        int n = arr.length;

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += dir;
            } else {
                arr[curr]--;
                dir = -dir;
                curr += dir;
            }
        }

        for (int num : arr) {
            if (num != 0) return false;
        }
        return true;
    }
}
