package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/water-bottles
 */

public class LC1518WaterBottles {
    public static void main(String[] args) {
        System.out.println(numWaterBottles(9, 3));   // 13
        System.out.println(numWaterBottles(15, 4));  // 19
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int drank = numBottles;
        while (numBottles >= numExchange) {
            int newFull = numBottles / numExchange;
            int remainder = numBottles % numExchange;
            drank += newFull;
            numBottles = newFull + remainder;
        }
        return drank;
    }
}
