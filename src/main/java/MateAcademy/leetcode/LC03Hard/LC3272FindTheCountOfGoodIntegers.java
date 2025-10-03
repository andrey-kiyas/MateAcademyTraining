package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-the-count-of-good-integers
 */

public class LC3272FindTheCountOfGoodIntegers {
    public static void main(String[] args) {
        System.out.println(countGoodIntegers(3, 5));  // Output: 27
        System.out.println(countGoodIntegers(1, 4));  // Output: 2
        System.out.println(countGoodIntegers(5, 6));  // Output: 2468
    }

    public static long countGoodIntegers(int n, int k) {
        long[] fac = new long[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++) {
            fac[i] = fac[i - 1] * i;
        }

        long result = 0;
        Set<String> vis = new HashSet<>();
        int base = (int) Math.pow(10, (n - 1) >> 1);

        for (int i = base; i < base * 10; i++) {
            String s = String.valueOf(i);
            StringBuilder sb = new StringBuilder(s).reverse();
            s += sb.substring(n % 2);
            if (Long.parseLong(s) % k != 0) {
                continue;
            }

            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String t = new String(arr);
            if (vis.contains(t)) {
                continue;
            }
            vis.add(t);
            int[] cnt = new int[10];
            for (char c : arr) {
                cnt[c - '0']++;
            }

            long res = (n - cnt[0]) * fac[n - 1];
            for (int x : cnt) {
                res /= fac[x];
            }
            result += res;
        }

        return result;
    }
}
