package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/weighted-word-mapping
 */

public class LC3838WeightedWordMapping {
    public static void main(String[] args) {
        int[] weights1 = {5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2};
        System.out.println(mapWordWeights(new String[]{"abcd", "def", "xyz"}, weights1)); // "rij"

        int[] weights2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(mapWordWeights(new String[]{"a", "b", "c"}, weights2));       // "yyy"

        int[] weights3 = {7, 5, 3, 4, 3, 5, 4, 9, 4, 2, 2, 7, 10, 2, 5, 10, 6, 1, 2, 2, 4, 1, 3, 4, 4, 5};
        System.out.println(mapWordWeights(new String[]{"abcd"}, weights3));               // "g"
    }

    public static String mapWordWeights(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int totalWeight = 0;

            for (int i = 0; i < word.length(); i++) {
                int charIndex = word.charAt(i) - 'a';
                totalWeight += weights[charIndex];
            }

            int mappedIndex = totalWeight % 26;

            char mappedChar = (char) ('z' - mappedIndex);
            result.append(mappedChar);
        }

        return result.toString();
    }
}
