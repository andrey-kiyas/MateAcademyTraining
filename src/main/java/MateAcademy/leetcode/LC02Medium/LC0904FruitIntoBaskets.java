package MateAcademy.leetcode.LC02Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/fruit-into-baskets
 */

public class LC0904FruitIntoBaskets {
    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 2, 1}));       // 3
        System.out.println(totalFruit(new int[]{0, 1, 2, 2}));    // 3
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2})); // 4
    }

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0;
        int maxFruits = 0;

        for (int right = 0; right < fruits.length; right++) {
            countMap.put(fruits[right], countMap.getOrDefault(fruits[right], 0) + 1);

            while (countMap.size() > 2) {
                countMap.put(fruits[left], countMap.get(fruits[left]) - 1);
                if (countMap.get(fruits[left]) == 0) {
                    countMap.remove(fruits[left]);
                }
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
        }

        return maxFruits;
    }
}
