package MateAcademy.leetcode.LC02Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits
 */

public class LC2342MaxSumOfAPairWithEqualSumOfDigits {
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{18, 43, 36, 13, 7}));
        System.out.println(maximumSum(new int[]{10, 12, 19, 14}));
    }

    public static int maximumSum(int[] nums) {
        Map<Integer, Integer> maxMap = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int digitSum = getDigitSum(num);

            if (maxMap.containsKey(digitSum)) {
                maxSum = Math.max(maxSum, maxMap.get(digitSum) + num);
                maxMap.put(digitSum, Math.max(maxMap.get(digitSum), num));
            } else {
                maxMap.put(digitSum, num);
            }
        }

        return maxSum;
    }

    public static int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
