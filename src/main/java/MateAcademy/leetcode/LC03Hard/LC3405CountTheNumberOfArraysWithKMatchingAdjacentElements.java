package MateAcademy.leetcode.LC03Hard;

public class LC3405CountTheNumberOfArraysWithKMatchingAdjacentElements {
    static final int MOD = 1_000_000_007;
    static final int MAX = 100_005;
    static long[] fact = new long[MAX];
    static long[] invFact = new long[MAX];

    public static void main(String[] args) {
        System.out.println(countGoodArrays(3, 2, 1)); // 4
        System.out.println(countGoodArrays(4, 2, 2)); // 6
        System.out.println(countGoodArrays(5, 2, 0)); // 2
    }

    public static int countGoodArrays(int n, int m, int k) {
        precomputeFactorials();
        long res = m;
        res = res * comb(n - 1, k) % MOD;
        res = res * modPow(m - 1, n - 1 - k) % MOD;
        return (int) res;
    }

    private static long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) != 0) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }

    private static void precomputeFactorials() {
        fact[0] = invFact[0] = 1;
        for (int i = 1; i < MAX; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[MAX - 1] = modPow(fact[MAX - 1], MOD - 2);
        for (int i = MAX - 2; i > 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    private static long comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        return fact[n] * invFact[k] % MOD * invFact[n - k] % MOD;
    }
}
