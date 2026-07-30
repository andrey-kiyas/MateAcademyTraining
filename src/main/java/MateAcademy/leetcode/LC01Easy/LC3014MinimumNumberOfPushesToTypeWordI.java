package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i
 */

public class LC3014MinimumNumberOfPushesToTypeWordI {
    public static void main(String[] args) {
        System.out.println(minimumPushes("abcde"));      // 5
        System.out.println(minimumPushes("xycdefghij")); // 12
    }

    public static int minimumPushes(String word) {
        int n = word.length();
        int pushes = 0;

        for (int i = 0; i < n; i++) {
            pushes += (i / 8) + 1;
        }

        return pushes;
    }
}
