package MateAcademy.leetcode.medium;

import java.util.List;

/**
 * https://leetcode.com/problems/minimum-index-of-a-valid-split
 */

public class LC2780MinimumIndexOfAValidSplit {
    public static void main(String[] args) {
        System.out.println(minimumIndex(List.of(1, 2, 2, 2)));                    // 2
        System.out.println(minimumIndex(List.of(2, 1, 3, 1, 1, 1, 7, 1, 2, 1)));  // 4
        System.out.println(minimumIndex(List.of(3, 3, 3, 3, 7, 2, 2)));           // -1
    }

    public static int minimumIndex(List<Integer> nums) {
        int n = nums.size();

        int candidate = 0, count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        int totalCount = 0;
        for (int num : nums) {
            if (num == candidate) {
                totalCount++;
            }
        }

        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i) == candidate) {
                leftCount++;
            }
            int leftSize = i + 1;
            int rightSize = n - leftSize;

            int rightCount = totalCount - leftCount;

            if (leftCount * 2 > leftSize && rightCount * 2 > rightSize) {
                return i;
            }
        }

        return -1;
    }
}
