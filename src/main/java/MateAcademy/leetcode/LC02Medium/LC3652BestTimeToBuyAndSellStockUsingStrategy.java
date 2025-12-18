package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-using-strategy
 */

public class LC3652BestTimeToBuyAndSellStockUsingStrategy {
    public static void main(String[] args) {
        System.out.println(maxProfit(
                new int[]{4, 2, 8},
                new int[]{-1, 0, 1},
                2
        )); // 10

        System.out.println(maxProfit(
                new int[]{5, 4, 3},
                new int[]{1, 1, 0},
                2
        )); // 9
    }

    public static long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        int half = k / 2;

        long baseProfit = 0;
        for (int i = 0; i < n; i++) {
            baseProfit += (long) strategy[i] * prices[i];
        }

        long[] prefOrig = new long[n + 1];
        long[] prefSell = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefOrig[i + 1] = prefOrig[i] + (long) strategy[i] * prices[i];
            prefSell[i + 1] = prefSell[i] + prices[i];
        }

        long bestGain = 0;

        for (int l = 0; l + k <= n; l++) {
            int mid = l + half;
            int r = l + k;

            long oldProfit = prefOrig[r] - prefOrig[l];
            long newProfit = prefSell[r] - prefSell[mid];

            long gain = newProfit - oldProfit;
            bestGain = Math.max(bestGain, gain);
        }

        return baseProfit + bestGain;
    }
}
