package MateAcademy.leetcode.LC01Easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount
 */

public class LC2144MinimumCostOfBuyingCandiesWithDiscount {
    public static void main(String[] args) {
        System.out.println(minimumCost(new int[]{1, 2, 3}));                // 5
        System.out.println(minimumCost(new int[]{6, 5, 7, 9, 2, 2}));       // 23
        System.out.println(minimumCost(new int[]{5, 5}));                   // 10
    }

    public static int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int totalCost = 0;
        int i = cost.length - 1;

        while (i >= 0) {
            totalCost += cost[i];
            i--;

            if (i >= 0) {
                totalCost += cost[i];
                i--;
            }

            i--;
        }

        return totalCost;
    }
}
