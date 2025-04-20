package MateAcademy.leetcode.LC02Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/rabbits-in-forest
 */

public class LC0781RabbitsInForest {
    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{1, 1, 2}));      // Output: 5
        System.out.println(numRabbits(new int[]{10, 10, 10}));   // Output: 11
    }

    public static int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int totalRabbits = 0;

        for (int answer : answers) {
            if (answer == 0) {
                totalRabbits += 1;
                continue;
            }

            if (!map.containsKey(answer)) {
                map.put(answer, 1);
                totalRabbits += answer + 1;
            } else {
                map.put(answer, map.get(answer) + 1);
                if (map.get(answer) > answer + 1) {
                    map.put(answer, 1);
                    totalRabbits += answer + 1;
                }
            }
        }

        return totalRabbits;
    }
}
