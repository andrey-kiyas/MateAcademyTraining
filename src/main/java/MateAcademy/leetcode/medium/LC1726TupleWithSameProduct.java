package MateAcademy.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/tuple-with-same-product
 */

public class LC1726TupleWithSameProduct {

    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[]{2,3,4,6}));    // Output: 8
        System.out.println(tupleSameProduct(new int[]{1,2,4,5,10})); // Output: 16
    }

    public static int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCount = new HashMap<>();
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int product = nums[i] * nums[j];
                productCount.put(product, productCount.getOrDefault(product, 0) + 1);
            }
        }

        for (int count : productCount.values()) {
            if (count > 1) {
                result += (count * (count - 1) / 2) * 8;
            }
        }

        return result;
    }
}
