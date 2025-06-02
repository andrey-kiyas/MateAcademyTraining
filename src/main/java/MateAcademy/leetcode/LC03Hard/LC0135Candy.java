package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/candy
 */

public class LC0135Candy {
    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 0, 2}));  // Output: 5
        System.out.println(candy(new int[]{1, 2, 2}));  // Output: 4
        System.out.println(candy2(new int[]{1, 0, 2})); // Output: 5
        System.out.println(candy2(new int[]{1, 2, 2})); // Output: 4
    }

    public static int candy(int[] ratings) {
        final int n = ratings.length;

        int result = 0;
        int[] l = new int[n];
        int[] r = new int[n];
        Arrays.fill(l, 1);
        Arrays.fill(r, 1);

        for (int i = 1; i < n; ++i)
            if (ratings[i] > ratings[i - 1])
                l[i] = l[i - 1] + 1;

        for (int i = n - 2; i >= 0; --i)
            if (ratings[i] > ratings[i + 1])
                r[i] = r[i + 1] + 1;

        for (int i = 0; i < n; ++i)
            result += Math.max(l[i], r[i]);

        return result;
    }

    public static int candy2(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int result = 0;
        for (int c : candies) {
            result += c;
        }
        return result;
    }
}
