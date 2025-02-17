package MateAcademy.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/letter-tile-possibilities
 */

public class LC1079LetterTilePossibilities {
    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAB"));
        System.out.println(numTilePossibilities("AAABBC"));
        System.out.println(numTilePossibilities("V"));
    }

    public static int numTilePossibilities(String tiles) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        return backtrack(count);
    }

    private static int backtrack(Map<Character, Integer> count) {
        int sum = 0;
        for (char c : count.keySet()) {
            if (count.get(c) > 0) {
                sum++;
                count.put(c, count.get(c) - 1);
                sum += backtrack(count);
                count.put(c, count.get(c) + 1);
            }
        }
        return sum;
    }
}
