package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays
 */

public class LC2040KthSmallestProductOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(kthSmallestProduct(new int[]{2, 5}, new int[]{3, 4}, 2));                       // 8
        System.out.println(kthSmallestProduct(new int[]{-4, -2, 0, 3}, new int[]{2, 4}, 6));               // 0
        System.out.println(kthSmallestProduct(new int[]{-2, -1, 0, 1, 2}, new int[]{-3, -1, 2, 4, 5}, 3)); // -6
    }

    public static long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -100_000_000_00L;
        long right = 100_000_000_00L;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (countLessOrEqual(nums1, nums2, mid) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static long countLessOrEqual(int[] nums1, int[] nums2, long x) {
        long count = 0;
        for (int a : nums1) {
            if (a > 0) {
                int l = 0, r = nums2.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long) a * nums2[m] <= x) l = m + 1;
                    else r = m;
                }
                count += l;
            } else if (a < 0) {
                int l = 0, r = nums2.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long) a * nums2[m] <= x) r = m;
                    else l = m + 1;
                }
                count += nums2.length - l;
            } else {
                if (x >= 0) count += nums2.length;
            }
        }
        return count;
    }
}
