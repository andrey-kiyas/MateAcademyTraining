package MateAcademy.leetcode.medium;

import java.util.List;

/**
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters
 */

public class LC1239MaximumLengthOfAConcatenatedStringWithUniqueCharacters {

    public static void main(String[] args) {
        List<String> arr1 = List.of("un", "iq", "ue");
        List<String> arr2 = List.of("cha", "r", "act", "ers");
        List<String> arr3 = List.of("abcdefghijklmnopqrstuvwxyz");

        System.out.println("Expected 4 - " + maxLength(arr1) + " Output");
        System.out.println("Expected 6 - " + maxLength(arr2) + " Output");
        System.out.println("Expected 26 - " + maxLength(arr3) + " Output");
    }

    public static int maxLength(List<String> arr) {
        return backtrack(arr, 0, "");
    }

    private static int backtrack(List<String> arr, int index, String current) {
        // Проверка, если текущая строка содержит дублирующиеся символы
        if (!isUnique(current)) {
            return 0;
        }

        int maxLength = current.length();

        // Перебираем массив строк начиная с текущего индекса
        for (int i = index; i < arr.size(); i++) {
            maxLength = Math.max(maxLength, backtrack(arr, i + 1, current + arr.get(i)));
        }

        return maxLength;
    }

    private static boolean isUnique(String str) {
        int[] charCount = new int[26];

        for (char c : str.toCharArray()) {
            if (charCount[c - 'a']++ > 0) {
                return false; // Символ уже встречался, строка не уникальна
            }
        }

        return true;
    }
}
