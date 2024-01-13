package MateAcademy.codewars;

import java.util.Arrays;

public class ScrollingText {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(scrollingText("codewars")));
    }

    public static String[] scrollingText(String text) {
        //solution
        String[] result = new String[text.length()];
        result[0] = text.toUpperCase();
        for (int i = 1; i < text.length(); i++) {
            result[i] = (text.substring(1) + text.charAt(0)).toUpperCase();
            text = result[i];
        }
        return result;
    }
}
