package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i
 */

public class LC3442MaximumDifferenceBetweenEvenAndOddFrequencyI {
    public static void main(String[] args) {
        System.out.println(maxDifference("aaaaabbc"));     // Output: 3
        System.out.println(maxDifference("abcabcab"));     // Output: 1
    }

    public static int maxDifference(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        for (int f : freq) {
            if (f > 0) {
                if (f % 2 == 1) {
                    maxOdd = Math.max(maxOdd, f);
                } else {
                    minEven = Math.min(minEven, f);
                }
            }
        }

        return maxOdd - minEven;
    }
}
