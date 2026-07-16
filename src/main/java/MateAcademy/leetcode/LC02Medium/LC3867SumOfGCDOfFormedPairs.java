package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/description
 */

public class LC3867SumOfGCDOfFormedPairs {
    public static void main(String[] args) {
        int[] nums1 = {2, 6, 4};
        System.out.println(gcdSum(nums1)); // 2

        int[] nums2 = {3, 6, 2, 8};
        System.out.println(gcdSum(nums2)); // 5
    }

    public static long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int maxVal = 0;

        for (int i = 0; i < n; i++) {
            maxVal = Math.max(maxVal, nums[i]);
            prefixGcd[i] = gcd(nums[i], maxVal);
        }

        Arrays.sort(prefixGcd);

        long sum = 0;
        int left = 0;
        int right = n - 1;

        while (left < right) {
            sum += gcd(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }

        return sum;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
