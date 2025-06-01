package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/distribute-candies-among-children-ii
 */

public class LC2929DistributeCandiesAmongChildrenII {
    public static void main(String[] args) {
        System.out.println(distributeCandies(5, 2));  // Output: 3
        System.out.println(distributeCandies(3, 3));  // Output: 10
    }

    public static long distributeCandies(int n, int limit) {
        long total = comb(n + 2);

        for (int i = 1; i <= 3; i++) {
            for (int mask = 1; mask < (1 << 3); mask++) {
                if (Integer.bitCount(mask) != i) continue;
                int sumOver = i * (limit + 1);
                int remaining = n - sumOver;
                if (remaining < 0) continue;
                long subtract = comb(remaining + 2);
                if (i % 2 == 1) total -= subtract;
                else total += subtract;
            }
        }

        return total;
    }

    private static long comb(int n) {
        if (n < 2) return 0;
        return (long) n * (n - 1) / 2;
    }
}
