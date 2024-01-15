package MateAcademy.codewars.CW7kyu;

/**
 * https://www.codewars.com/kata/55960bbb182094bc4800007b/train/java
 */

public class InsertDashes {

    public static void main(String[] args) {
        System.out.println(insertDash(454793));

//        System.out.println(4.2%1);
    }

    public static String insertDash(int num) {
        // Your code here...
        char[] digits = Integer.toString(num).toCharArray();
        StringBuilder builder = new StringBuilder(String.valueOf(digits[0]));
        for (int i = 1; i < digits.length; i++) {
            if (digits[i-1] % 2 != 0 && digits[i] % 2 != 0) {
                builder.append("-");
            }
            builder.append(digits[i]);
        }
        return String.valueOf(builder);
    }
}
