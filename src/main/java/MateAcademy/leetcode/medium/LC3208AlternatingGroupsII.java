package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/alternating-groups-ii
 */

public class LC3208AlternatingGroupsII {
    public static void main(String[] args) {
        System.out.println(numberOfAlternatingGroups(new int[]{0, 1, 0, 1, 0}, 3));       // 3
        System.out.println(numberOfAlternatingGroups(new int[]{0, 1, 0, 0, 1, 0, 1}, 6)); // 2
        System.out.println(numberOfAlternatingGroups(new int[]{1, 1, 0, 1}, 4));          // 0
        System.out.println(numberOfAlternatingGroups(new int[]{0, 1, 1}, 3));             // 1



    }

    public static int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int result = 0, count = 0;

        for (int i = 0; i < n << 1; ++i) {
            if (i > 0 && colors[i % n] == colors[(i - 1) % n]) {
                count = 1;
            } else {
                ++count;
            }
            result += i >= n && count >= k ? 1 : 0;
        }

        return result;
    }
}
