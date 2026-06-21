package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/maximum-ice-cream-bars
 */

public class LC1833MaximumIceCreamBars {
    public static void main(String[] args) {
        System.out.println(maxIceCream(new int[]{1, 3, 2, 4, 1}, 7));      // 4
        System.out.println(maxIceCream(new int[]{10, 6, 8, 7, 7, 8}, 5));  // 0
        System.out.println(maxIceCream(new int[]{1, 6, 3, 1, 2, 5}, 20));  // 6
    }

    public static int maxIceCream(int[] costs, int coins) {
        int maxCost = 0;
        for (int cost : costs) {
            if (cost > maxCost) {
                maxCost = cost;
            }
        }

        int[] count = new int[maxCost + 1];
        for (int cost : costs) {
            count[cost]++;
        }

        int iceCreamBars = 0;

        for (int price = 1; price <= maxCost; price++) {
            if (count[price] == 0) {
                continue;
            }

            if (coins < price) {
                break;
            }

            int countToBuy = Math.min(count[price], coins / price);

            iceCreamBars += countToBuy;
            coins -= countToBuy * price;
        }

        return iceCreamBars;
    }
}
