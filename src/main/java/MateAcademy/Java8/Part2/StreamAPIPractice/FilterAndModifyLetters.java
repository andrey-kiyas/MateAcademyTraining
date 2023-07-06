package MateAcademy.Java8.Part2.StreamAPIPractice;

import java.util.stream.IntStream;

/**
 * У тебе є рядок input з випадковими літерами без цифр і знаків пунктуації. Твоє завдання:
 * видали кожну літеру з непарним індексом та поверни результат у верхньому регістрі. Наприклад:
 * <p>
 * Input: "random"
 * Result: "RNO"
 * <p>
 * Input: "a"
 * Result: "A"
 */

public class FilterAndModifyLetters {
    public static String filterLetters(String input) {
        char[] chars = input.toCharArray();
        return IntStream.range(0, chars.length)
                .filter(value -> value % 2 == 0)
                .mapToObj(value -> chars[value])
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append).toString().toUpperCase();
    }
}
