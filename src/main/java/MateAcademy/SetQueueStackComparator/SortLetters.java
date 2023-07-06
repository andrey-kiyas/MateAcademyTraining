package MateAcademy.SetQueueStackComparator;

import java.io.BufferedWriter;
import java.util.Set;
import java.util.TreeSet;

public class SortLetters {
    public static void main(String[] args) {
        final int DEFAULT_VALUE = 5;

//        String text = "ur-BvT?^ ra w; p"; // result should be "abprt"
//        String text = "A _f*c a?F10"; // result should be "acf"

        String text1 = "ur-BvT?^ ra w; p";
        String text2 = "A _f*c a?F10";

        getUniqueCharacters(text1);

    }


    public static String getUniqueCharacters(String text) {
        Set<String> sortedText = new TreeSet<>();
        char[] textToArray = text.toCharArray();
        for (char str : textToArray) {
            if (Character.isLetter(str)){
                sortedText.add(Character.toString(str).toLowerCase());
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String str : sortedText) {
            builder.append(str);
        }
//        System.out.println(sortedText);
//        System.out.println(builder);
//        System.out.println(builder.substring(0, 5));



        return (builder.length() <= 5 ) ? String.valueOf(builder) : builder.substring(0, 5);
    }
}
