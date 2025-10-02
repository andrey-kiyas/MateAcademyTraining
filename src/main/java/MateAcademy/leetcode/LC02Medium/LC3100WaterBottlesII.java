package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/water-bottles-ii
 */

public class LC3100WaterBottlesII {
    public static void main(String[] args) {
        System.out.println(maxBottlesDrunk(13, 6)); // 15
        System.out.println(maxBottlesDrunk(10, 3)); // 13
    }

    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int drank = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            empty -= numExchange;
            drank++;
            empty++;
            numExchange++;
        }
        return drank;
    }
}
