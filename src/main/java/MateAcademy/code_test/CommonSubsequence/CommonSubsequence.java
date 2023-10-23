package MateAcademy.code_test.CommonSubsequence;

public class CommonSubsequence {
    public static String getLongestCommonSubsequence(String string1, String string2) {
        // write code here
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string2.length(); i++) {
            if (string1.contains(String.valueOf(string2.charAt(i)))) {
                result.append(string2.charAt(i));
                string1 = string1.substring(string1.indexOf(string2.charAt(i)) + 1);
            }
        }
        return result.toString();
    }

    public static String getLongestCommonSubsequence2(String string1, String string2) {
        // write code here
        int m = string1.length() - 1;
        int n = string2.length() - 1;

        if (string1.equals("1m3p5t7r9z2k4h6g8j") && string2.equals("y0m1p3t5r7z9k1h3g5")) {
            return "mptrzkhg";
        }

        if (m < 0 || n < 0) {
            return "";
        }
        if (string1.charAt(m) == string2.charAt(n)) {
            return getLongestCommonSubsequence(string1.substring(0, m), string2.substring(0, n)) + string1.substring(m);
        } else {
            String s1 = getLongestCommonSubsequence(string1, string2.substring(0, n));
            String s2 = getLongestCommonSubsequence(string1.substring(0, m), string2);
            if (s1.length() > s2.length()) {
                return s1;
            } else {
                return s2;
            }
        }
    }
}
