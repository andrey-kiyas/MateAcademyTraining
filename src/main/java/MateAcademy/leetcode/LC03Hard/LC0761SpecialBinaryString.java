package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/special-binary-string
 */

public class LC0761SpecialBinaryString {
    public static void main(String[] args) {
        System.out.println(makeLargestSpecial("11011000")); // "11100100"
        System.out.println(makeLargestSpecial("10"));       // "10"
    }

    public static String makeLargestSpecial(String s) {
        int count = 0, i = 0;
        List<String> res = new ArrayList<>();

        for (int j = 0; j < s.length(); ++j) {
            if (s.charAt(j) == '1') count++;
            else count--;

            if (count == 0) {
                res.add("1" + makeLargestSpecial(s.substring(i + 1, j)) + "0");
                i = j + 1;
            }
        }

        res.sort(Collections.reverseOrder());

        return String.join("", res);
    }
}
