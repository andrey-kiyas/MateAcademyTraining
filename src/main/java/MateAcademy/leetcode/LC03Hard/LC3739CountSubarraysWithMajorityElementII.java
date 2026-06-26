package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/count-subarrays-with-majority-element-ii
 */

public class LC3739CountSubarraysWithMajorityElementII {
    public static void main(String[] args) {
        System.out.println(countMajoritySubarrays(new int[]{1, 2, 2, 3}, 2)); // 5
        System.out.println(countMajoritySubarrays(new int[]{1, 1, 1, 1}, 1)); // 10
        System.out.println(countMajoritySubarrays(new int[]{1, 2, 3}, 4));    // 0
    }

    public static long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        int[] countMap = new int[2 * n + 1];

        int prefixSum = 0;
        countMap[prefixSum + n] = 1;

        long totalSubarrays = 0;
        long validCountWithCurrentSum = 0;

        for (int num : nums) {
            int oldSum = prefixSum;

            if (num == target) {
                prefixSum += 1;
                validCountWithCurrentSum += countMap[oldSum + n];
            } else {
                prefixSum -= 1;
                validCountWithCurrentSum -= countMap[prefixSum + n];
            }

            totalSubarrays += validCountWithCurrentSum;

            countMap[prefixSum + n]++;
        }

        return totalSubarrays;
    }
}
