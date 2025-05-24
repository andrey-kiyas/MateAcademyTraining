package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/clear-digits
 */

public class LC3174ClearDigits {

    public static void main(String[] args) {
        System.out.println(clearDigits("abc"));
        System.out.println(clearDigits("cb34"));
    }

    public static String clearDigits(String s) {
        StringBuilder builder = new StringBuilder(s);

        int i = 1;
        while (i < builder.length()) {
            if (Character.isDigit(builder.charAt(i))) {
                builder.delete(i - 1, i + 1);
                i--;
            } else {
                i++;
            }
        }

        return builder.toString();
    }

    public static String clearDigits2(String s) {
        boolean isDigits = false;
        StringBuilder builder = new StringBuilder(s);
        while (builder.length() != 0 && builder.toString().matches(".*\\d.*")) {
            for (int i = 1; i < builder.length(); i++) {
                if (Character.isDigit(builder.charAt(i))) {
                    builder.delete(i - 1, i + 1);
                }
            }
        }
        return String.valueOf(builder);
    }
}
