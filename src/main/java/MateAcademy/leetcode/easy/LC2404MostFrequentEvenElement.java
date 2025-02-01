package MateAcademy.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/most-frequent-even-element
 */

public class LC2404MostFrequentEvenElement {

    public static void main(String[] args) {
        System.out.println(mostFrequentEven(new int[]{0, 1, 2, 2, 4, 4, 1}));           // Output: 2
        System.out.println(mostFrequentEven(new int[]{4, 4, 4, 9, 2, 4}));              // Output: 4
        System.out.println(mostFrequentEven(new int[]{29, 47, 21, 41, 13, 37, 25, 7})); // Output: -1
    }

    public static int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
        }
        int mostFrequent = -1;
        int maxFrequency = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            if (frequency > maxFrequency || (frequency == maxFrequency && num < mostFrequent)) {
                mostFrequent = num;
                maxFrequency = frequency;
            }
        }
        return mostFrequent;
    }
}
