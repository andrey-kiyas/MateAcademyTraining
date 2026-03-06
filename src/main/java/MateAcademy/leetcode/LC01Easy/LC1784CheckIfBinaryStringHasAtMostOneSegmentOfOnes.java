package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/description
 */

public class LC1784CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
    public static void main(String[] args) {
        System.out.println(checkOnesSegment("1001")); // false
        System.out.println(checkOnesSegment("110"));  // true
    }

    public static boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
