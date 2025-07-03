package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/find-the-k-th-character-in-string-game-i
 */

public class LC3304FindTheKThCharacterInStringGameI {
    public static void main(String[] args) {
        System.out.println(kthCharacter(5));   // b
        System.out.println(kthCharacter(10));  // c
    }

    public static char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");
        while (sb.length() < k) {
            int len = sb.length();
            for (int i = 0; i < len && sb.length() < k; i++) {
                sb.append(next(sb.charAt(i)));
            }
        }
        return sb.charAt(k - 1);
    }

    private static char next(char c) {
        return (char) ((c - 'a' + 1) % 26 + 'a');
    }
}
