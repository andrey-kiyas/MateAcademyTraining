package MateAcademy.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/description
 */

public class UniqueNumberOfOccurrences1207 {

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));        // true
        System.out.println(uniqueOccurrences(new int[]{1, 2}));                    // false
        System.out.println(uniqueOccurrences(new int[]{-3,0,1,-3,1,1,1,-3,10,0})); // true
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurrencesMap = new HashMap<>();
        for (int num : arr) {
            occurrencesMap.put(num, occurrencesMap.getOrDefault(num, 0) + 1);
        }
        Set<Integer> uniqueOccurrences = new HashSet<>(occurrencesMap.values());
        System.out.println(occurrencesMap + " --- " + uniqueOccurrences);
        return uniqueOccurrences.size() == occurrencesMap.size();
    }
}
