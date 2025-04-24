package MateAcademy.leetcode.LC02Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/count-complete-subarrays-in-an-array
 */

public class LC2799CountCompleteSubarraysInAnArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 1, 2, 2};
        int[] nums2 = {5, 5, 5, 5};

        System.out.println(countCompleteSubarrays(nums1)); // Output: 4
        System.out.println(countCompleteSubarrays(nums2)); // Output: 10
    }

    public static int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int result = 0;

        // Кількість унікальних елементів в усьому масиві
        Set<Integer> allDistinct = new HashSet<>();
        for (int num : nums) {
            allDistinct.add(num);
        }
        int totalUnique = allDistinct.size();

        // Перевіряємо всі підмасиви
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                seen.add(nums[j]);
                if (seen.size() == totalUnique) {
                    result++;
                }
            }
        }

        return result;
    }
}
