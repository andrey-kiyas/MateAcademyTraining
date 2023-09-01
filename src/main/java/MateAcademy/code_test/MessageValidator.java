package MateAcademy.code_test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MessageValidator {
    public static void main(String[] args) {
        System.out.println(isValidMessage("2ey1h"));
    }

    public static boolean isValidMessage(String message) {
        if (message.equals("0") || message.length() == 0) {
            return true;
        }
        List<String> numbers = Arrays.stream(message.split("[a-zA-Z]+")).collect(Collectors.toList());
        List<String> words = Arrays.stream(message.split("[0-9 ]+")).collect(Collectors.toList());
        words.remove(0);
        if (words.size() != numbers.size() || numbers.size() == 0) {
            return false;
        }
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() != Integer.parseInt(numbers.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidMessage1(String message) {
        int digit = 0;
        int chLength = 0;
        int counter = 0;

        char[] charArray = message.toCharArray();
        for (char ch : charArray) {
            counter++;
            if (Character.isLetter(ch)) {
                chLength++;
                if (counter == message.length()) {
                    if (digit != chLength) {
                        return false;
                    }
                }
            }
            if (Character.isDigit(ch)) {
                if (chLength != 0 || counter == message.length()) {
                    if (digit != chLength) {
                        return false;
                    }
                }
                digit = Character.getNumericValue(ch);
                chLength = 0;
            }
        }
        return true;
    }
}
