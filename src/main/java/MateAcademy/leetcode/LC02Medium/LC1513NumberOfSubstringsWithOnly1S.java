package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/number-of-substrings-with-only-1s
 */

public class LC1513NumberOfSubstringsWithOnly1S {
    public static void main(String[] args) {
        System.out.println(numSub("0110111")); // 9
        System.out.println(numSub("101"));     // 2
        System.out.println(numSub("111111"));  // 21
    }

    public static int numSub(String s) {
        long MOD = 1_000_000_007;
        long result = 0;
        long count = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
            } else {
                result += count * (count + 1) / 2;
                result %= MOD;
                count = 0;
            }
        }

        result += count * (count + 1) / 2;
        result %= MOD;

        return (int) result;
    }
}
