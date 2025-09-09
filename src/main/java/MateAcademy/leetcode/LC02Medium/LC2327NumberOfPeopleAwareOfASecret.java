package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/number-of-people-aware-of-a-secret
 */

public class LC2327NumberOfPeopleAwareOfASecret {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(peopleAwareOfSecret(6, 2, 4)); // 5
        System.out.println(peopleAwareOfSecret(4, 1, 3)); // 6
    }

    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        long share = 0;
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n; ++i) {
            if (i - delay >= 0)
                share += dp[i - delay];
            if (i - forget >= 0)
                share -= dp[i - forget];
            share += MOD;
            share %= MOD;
            dp[i] = (int) share;
        }

        int result = 0;
        for (int i = n - forget; i < n; ++i)
            result = (result + dp[i]) % MOD;
        return result;
    }
}
