package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/count-good-numbers
 */

public class LC1922CountGoodNumbers {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1));   // Output: 5
        System.out.println(countGoodNumbers(4));   // Output: 400
        System.out.println(countGoodNumbers(50));  // Output: 564908303
    }

    public static int countGoodNumbers(long n) {
        long even = (n + 1) / 2;
        long odd = n / 2;

        long pow5 = modPow(5, even, MOD);
        long pow4 = modPow(4, odd, MOD);

        return (int) (pow5 * pow4 % MOD);
    }

    private static long modPow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }

        return result;
    }
}
