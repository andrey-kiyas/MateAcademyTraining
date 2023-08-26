package MateAcademy.code_test;

import java.util.Arrays;

public class Dictionary {
  private final String[] words;

    public Dictionary(String[] words) {
        this.words = words;
    }

//    public String findMostSimilar(String term) {
//        // TODO: this is your task ;)
//        return null;
//    }


  public String findMostSimilar(String word) {
        int[] findMin = new int[words.length];

        int min = words.length;

        for (int i = 0; i < words.length; i++) {
            findMin[i] = calculate(words[i], word);
        }
        for (int num : findMin) {
            if (min > num) {
                min = num;
            }
        }
        String result = "";
        for (int i = 0; i < findMin.length; i++) {
            if (findMin[i] == min) {
                result = words[i];
            }
        }
        return result;
    }


    ///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////
    static int calculate(String x, String y) {
        if (x.isEmpty()) {
            return y.length();
        }
        if (y.isEmpty()) {
            return x.length();
        }
        int substitution = calculate(x.substring(1), y.substring(1))
                + costOfSubstitution(x.charAt(0), y.charAt(0));
        int insertion = calculate(x, y.substring(1)) + 1;
        int deletion = calculate(x.substring(1), y) + 1;

        return min(substitution, insertion, deletion);
    }

    public static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    public static int min(int... numbers) {
        return Arrays.stream(numbers)
                .min().orElse(Integer.MAX_VALUE);
    }
}