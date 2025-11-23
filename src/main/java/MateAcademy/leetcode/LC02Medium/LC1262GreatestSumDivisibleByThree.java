package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/greatest-sum-divisible-by-three
 */

public class LC1262GreatestSumDivisibleByThree {
    public static void main(String[] args) {
        System.out.println(maxSumDivThree(new int[]{3, 6, 5, 1, 8})); // 18
        System.out.println(maxSumDivThree(new int[]{4}));             // 0
        System.out.println(maxSumDivThree(new int[]{1, 2, 3, 4, 4})); // 12
    }

    public static int maxSumDivThree(int[] nums) {
        int sum = 0;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        int secMin1 = Integer.MAX_VALUE;
        int secMin2 = Integer.MAX_VALUE;

        for (int x : nums) {
            sum += x;
            int r = x % 3;

            if (r == 1) {
                if (x < min1) {
                    secMin1 = min1;
                    min1 = x;
                } else if (x < secMin1) {
                    secMin1 = x;
                }
            } else if (r == 2) {
                if (x < min2) {
                    secMin2 = min2;
                    min2 = x;
                } else if (x < secMin2) {
                    secMin2 = x;
                }
            }
        }

        int mod = sum % 3;
        if (mod == 0) return sum;

        int option1, option2 = Integer.MAX_VALUE;

        if (mod == 1) {
            option1 = min1;
            if (min2 < Integer.MAX_VALUE && secMin2 < Integer.MAX_VALUE)
                option2 = min2 + secMin2;
        } else {
            option1 = min2;
            if (min1 < Integer.MAX_VALUE && secMin1 < Integer.MAX_VALUE)
                option2 = min1 + secMin1;
        }

        int toRemove = Math.min(option1, option2);
        if (toRemove == Integer.MAX_VALUE) return 0;

        return sum - toRemove;
    }
}
