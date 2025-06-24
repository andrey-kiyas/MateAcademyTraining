package MateAcademy.leetcode.LC01Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-all-k-distant-indices-in-an-array
 */

public class LC2200FindAllKDistantIndicesInAnArray {
    public static void main(String[] args) {
        System.out.println(findKDistantIndices(new int[]{3,4,9,1,3,9,5}, 9, 1)); // [1,2,3,4,5,6]
        System.out.println(findKDistantIndices(new int[]{2,2,2,2,2}, 2, 2));     // [0,1,2,3,4]
    }

    public static List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> resultSet = new HashSet<>();

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == key) {
                int start = Math.max(0, j - k);
                int end = Math.min(nums.length - 1, j + k);
                for (int i = start; i <= end; i++) {
                    resultSet.add(i);
                }
            }
        }

        List<Integer> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }
}
