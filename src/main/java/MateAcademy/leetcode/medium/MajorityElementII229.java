package MateAcademy.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/majority-element-ii
 */

public class MajorityElementII229 {

    public static void main(String[] args) {
//        MajorityElements solution = new MajorityElements();
        System.out.println(majorityElement(new int[]{3, 2, 3})); // Output: [3]
        System.out.println(majorityElement(new int[]{1}));       // Output: [1]
        System.out.println(majorityElement(new int[]{1, 2}));    // Output: [1, 2]
    }

    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int candidate1 = nums[0], count1 = 0;
        int candidate2 = nums[0], count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        // Count occurrences of candidate1 and candidate2
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        // Check if candidates meet the requirement
        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }
        if (count2 > nums.length / 3 && candidate1 != candidate2) {
            result.add(candidate2);
        }
        return result;
    }
}
