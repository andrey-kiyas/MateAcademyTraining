package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/remove-all-occurrences-of-a-substring
 */

public class LC1910RemoveAllOccurrencesOfASubstring {

    public static void main(String[] args) {
        System.out.println(removeOccurrences("012abcabc345678", "abc")); // 012345678
        System.out.println(removeOccurrences("daabcbaabcbc", "abc"));    // dab
        System.out.println(removeOccurrences("axxxxyyyyb", "xy"));       // ab
    }

    public static String removeOccurrences(String s, String part){
        StringBuilder builder = new StringBuilder(s);
        int index;

        while ((index = builder.indexOf(part)) != -1) {
            builder.delete(index, index + part.length());
        }

        return builder.toString();
    }

    public static String removeOccurrences2(String s, String part) {
        StringBuilder builder = new StringBuilder(s);
        int startIndex, endIndex = 0;

        while (builder.toString().contains(part)) {
            startIndex = builder.toString().toLowerCase().indexOf(part.toLowerCase());
            endIndex = startIndex + part.length() - 1;
            builder.delete(startIndex, endIndex + 1);
        }

        return builder.toString();
    }
}
