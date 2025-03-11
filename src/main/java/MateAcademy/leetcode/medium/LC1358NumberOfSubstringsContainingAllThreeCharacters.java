package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters
 */

public class LC1358NumberOfSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc")); // 10
        System.out.println(numberOfSubstrings("aaacb"));  // 3
        System.out.println(numberOfSubstrings("abc"));    // 1
    }

    public static int numberOfSubstrings(String s) {
        int left = 0, count = 0;
        int[] freq = new int[3];

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += s.length() - right;
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return count;
    }
}
