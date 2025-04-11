package MateAcademy.leetcode.easy;

/**
 * https://leetcode.com/problems/count-symmetric-integers
 */

public class LC2843CountSymmetricIntegers {
    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(1, 100));      // Output: 9
        System.out.println(countSymmetricIntegers(1200, 1230));  // Output: 4
    }

    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {
            String s = String.valueOf(i);
            int len = s.length();
            if (len % 2 != 0) continue;

            int half = len / 2;
            int sum1 = 0, sum2 = 0;
            for (int j = 0; j < half; j++) {
                sum1 += s.charAt(j) - '0';
                sum2 += s.charAt(j + half) - '0';
            }

            if (sum1 == sum2) count++;
        }

        return count;
    }
}
