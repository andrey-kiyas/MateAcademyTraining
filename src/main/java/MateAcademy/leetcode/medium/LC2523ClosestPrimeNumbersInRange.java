package MateAcademy.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/closest-prime-numbers-in-range
 */

public class LC2523ClosestPrimeNumbersInRange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(closestPrimes(10, 19))); // [11, 13]
        System.out.println(Arrays.toString(closestPrimes(4, 6)));   // [-1, -1]
    }

    public static int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = Math.max(left, 2); i <= right; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        int minDiff = Integer.MAX_VALUE;
        int[] result = new int[2];
        for (int i = 1; i < primes.size(); i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                result[0] = primes.get(i - 1);
                result[1] = primes.get(i);
            }
        }

        return result;
    }
}
