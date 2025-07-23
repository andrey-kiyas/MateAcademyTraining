package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description
 */

public class LC1790CheckIfOneStringSwapCanMakeStringsEqual {

    public static void main(String[] args) {
        System.out.println(areAlmostEqual("bank", "kanb"));
        System.out.println(areAlmostEqual("attack", "defend"));
        System.out.println(areAlmostEqual("kelb", "kelb"));
    }

    public static boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int count = 0;
        int[] mismatch = new int[2];

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (count == 2) {
                    return false;
                }
                mismatch[count++] = i;
            }
        }

        return count == 2 &&
                s1.charAt(mismatch[0]) == s2.charAt(mismatch[1]) &&
                s1.charAt(mismatch[1]) == s2.charAt(mismatch[0]);
    }


    public static boolean areAlmostEqual2(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        if (s1.length() == s2.length()) {
            int count = 0, ch1 = 0, ch2 = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    count++;
                    if (count == 1) {
                        ch1 = i;
                    } else if (count == 2) {
                        ch2 = i;
                    } else {
                        return false;
                    }
                }
            }
            return s1.equals(swapChars(s2, ch1, ch2));
        }
        return false;
    }

    public static String swapChars(String str, int i, int j) {
        StringBuilder builder = new StringBuilder(str);
        char tempChar = builder.charAt(i);
        builder.setCharAt(i, builder.charAt(j));
        builder.setCharAt(j, tempChar);
        return builder.toString();
    }
}
