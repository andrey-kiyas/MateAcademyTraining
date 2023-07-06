package MateAcademy.Java8.Part2.StreamAPIPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Реалізуй метод getUppercaseString(), який приймає масив рядків sourceStrings
 * та повертає список рядків, у якому:
 * <p>
 * кожен рядок починається з малої літери — "a" або "b";
 * довжина кожного рядка 3 або більше.
 * Поверни ці рядки у верхньому регістрі.
 * <p>
 * Наприклад:
 * <p>
 * Input: new String[]{"b"}
 * Result: List.of();
 * <p>
 * Input: new String[]{"abc"}
 * Result: List.of("ABC");
 * <p>
 * Input: new String[]{"aaa", "bbbb", "ccccc"}
 * Result: List.of("AAA", "BBBB")
 */

public class UppercaseString {
    public static void main(String[] args) {
        String[] sourceStrings = new String[]{"aaa", "bbbb", "ccccc"};
        System.out.println(getUppercaseString(sourceStrings));
    }

    public static List<String> getUppercaseString(String[] sourceStrings) {
        return Arrays.stream(sourceStrings)
                .filter(c -> (c.charAt(0) == 'a' || c.charAt(0) == 'b') && c.length() >= 3)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
