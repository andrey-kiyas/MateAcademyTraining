package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/ones-and-zeroes
 */

public class LC0474OnesAndZeroes {
    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3)); // 4
        System.out.println(findMaxForm(new String[]{"10", "0", "1"}, 1, 1));                   // 2
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] result = new int[m + 1][n + 1];

        for (String s : strs) {
            int zeros = 0, ones = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }

            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    result[i][j] = Math.max(result[i][j], result[i - zeros][j - ones] + 1);
                }
            }
        }

        return result[m][n];
    }
}
