package MateAcademy.more;

import java.util.Arrays;

public class dictionaryApp {
    public static void main(String[] args) {
//        Dictionary dictionary = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});
//        dictionary.findMostSimilar("berry");
//        String[] dictionary = new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"};
//        String word = "berry";
        String[] dictionary = new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"};
        String word = "berry";
        findMostSimilar(dictionary, word);
//        System.out.println(calculate("cherry", "berry"));
//        System.out.println(calculate("pineapple", "berry"));
//        System.out.println(calculate("melon", "berry"));
//        System.out.println(calculate("strawberry", "berry"));
//        System.out.println(calculate("raspberry", "berry"));
//    static int calculate(String x, String y) {
    }


    static String findMostSimilar(String[] dictionary, String word) {
        int[] findMin = new int[dictionary.length];
        int min = word.length();
        for (int i = 0; i < dictionary.length; i++) {
            findMin[i] = calculate(dictionary[i], word);
        }
        for (int num : findMin) {
            if (min > num){
                min = num;
            }
        }
        String result = "";
        for (int i = 0; i < findMin.length; i++) {
            if (findMin[i] == min){
                result = dictionary[i];
            }
        }
        return result;
    }

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
