package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/xor-after-range-multiplication-queries-ii
 */

public class LC3655XORAfterRangeMultiplicationQueriesII {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int[][] q1 = {{0, 2, 1, 4}};
        System.out.println(xorAfterQueries(nums1, q1)); // 4

        int[] nums2 = {2, 3, 1, 5, 4};
        int[][] q2 = {{1, 4, 2, 3}, {0, 2, 1, 2}};
        System.out.println(xorAfterQueries(nums2, q2)); // 31
    }

    public static int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int B = (int) Math.sqrt(n) + 1;

        long[] mul = new long[n];
        Arrays.fill(mul, 1L);

        List<List<int[]>> small = new ArrayList<>(B + 1);
        for (int i = 0; i <= B; i++) {
            small.add(new ArrayList<>());
        }

        for (int[] qu : queries) {
            int l = qu[0], r = qu[1], k = qu[2], v = qu[3];
            if (k > B) {
                for (int idx = l; idx <= r; idx += k) {
                    mul[idx] = (mul[idx] * v) % MOD;
                }
            } else {
                small.get(k).add(qu);
            }
        }

        for (int k = 1; k <= B; k++) {
            if (small.get(k).isEmpty()) continue;

            List<List<int[]>> byRem = new ArrayList<>(k);
            for (int r = 0; r < k; r++) {
                byRem.add(new ArrayList<>());
            }

            for (int[] qu : small.get(k)) {
                byRem.get(qu[0] % k).add(qu);
            }

            for (int rem = 0; rem < k; rem++) {
                if (byRem.get(rem).isEmpty()) continue;

                int len = (n - 1 - rem) / k + 1;
                long[] diff = new long[len + 1];
                Arrays.fill(diff, 1L);

                for (int[] qu : byRem.get(rem)) {
                    int l = qu[0], r = qu[1], v = qu[3];
                    int L = (l - rem) / k;
                    int R = (r - rem) / k;

                    diff[L] = (diff[L] * v) % MOD;
                    if (R + 1 < len) {
                        diff[R + 1] = (diff[R + 1] * modInverse(v)) % MOD;
                    }
                }

                long curMultiplier = 1L;
                int pos = 0;
                for (int idx = rem; idx < n; idx += k) {
                    curMultiplier = (curMultiplier * diff[pos]) % MOD;
                    mul[idx] = (mul[idx] * curMultiplier) % MOD;
                    pos++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            long finalVal = (nums[i] * mul[i]) % MOD;
            ans ^= (int) finalVal;
        }

        return ans;
    }

    @SuppressWarnings("SameParameterValue")
    private static long modPow(long a, long e) {
        long res = 1L;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) {
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            e >>= 1;
        }
        return res;
    }

    private static long modInverse(long x) {
        return modPow(x, MOD - 2);
    }
}
