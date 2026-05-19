package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/minimum-common-value
 */

public class LC2540MinimumCommonValue {
    public static void main(String[] args) {
        System.out.println(getCommon(new int[]{1, 2, 3}, new int[]{2, 4}));          // 2
        System.out.println(getCommon(new int[]{1, 2, 3, 6}, new int[]{2, 3, 4, 5})); // 2
    }

    public static int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return -1;
    }
}
