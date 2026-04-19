package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/maximum-distance-between-a-pair-of-values
 */

public class LC1855MaximumDistanceBetweenAPairOfValues {
    public static void main(String[] args) {
        System.out.println(maxDistance(new int[]{55, 30, 5, 4, 2}, new int[]{100, 20, 10, 10, 5})); // 2
        System.out.println(maxDistance(new int[]{2, 2, 2}, new int[]{10, 10, 1}));                  // 1
        System.out.println(maxDistance(new int[]{30, 29, 19, 5}, new int[]{25, 25, 25, 25, 25}));   // 2
    }

    public static int maxDistance(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int maxDist = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                maxDist = Math.max(maxDist, j - i);
                j++;
            } else {
                i++;
                if (i > j) {
                    j = i;
                }
            }
        }

        return maxDist;
    }
}
