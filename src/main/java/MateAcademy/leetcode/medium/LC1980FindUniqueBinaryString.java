package MateAcademy.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-unique-binary-string
 */

public class LC1980FindUniqueBinaryString {
    public static void main(String[] args) {
        System.out.println(findDifferentBinaryString(new String[]{"01","10"}));         // "11"
        System.out.println(findDifferentBinaryString(new String[]{"00","01"}));         // "11"
        System.out.println(findDifferentBinaryString(new String[]{"111","011","001"})); // "101"
    }

    public static String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>(Arrays.asList(nums));

        int n = nums.length;
        for (int i = 0; i < (1 << n); i++) {
            String candidate = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
            if (!set.contains(candidate)) {
                return candidate;
            }
        }

        return "";
    }
}
