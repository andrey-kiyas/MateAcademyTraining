package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation
 */

public class LC0762PrimeNumberOfSetBitsInBinaryRepresentation {
    public static void main(String[] args) {
        System.out.println(countPrimeSetBits(6, 10));  // 4
        System.out.println(countPrimeSetBits(10, 15)); // 5
    }

    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);
            if (isPrime(setBits)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int n) {
        // Оскільки n <= 20 (для чисел до 10^6), ми можемо використати швидку перевірку
        return n == 2 || n == 3 || n == 5 || n == 7 || n == 11
                || n == 13 || n == 17 || n == 19;
    }
}
