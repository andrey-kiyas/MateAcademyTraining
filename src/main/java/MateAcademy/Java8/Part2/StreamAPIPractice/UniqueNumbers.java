package MateAcademy.Java8.Part2.StreamAPIPractice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Реалізуй метод getUniqueNumbers(), який приймає рядок sourceNumber та повертає список
 * з усіма унікальними числами у вигляді символів із даного рядка. Наприклад:
 *
 * Input: "1"
 * Result: List.of('1');
 *
 * Input: "4444"
 * Result: List.of('4');
 *
 * Input: "987"
 * Result: List.of('9', '8', '7');
 */

public class UniqueNumbers {
    public static List<Character> getUniqueNumbers(String sourceNumber) {
        return sourceNumber.chars()
                .distinct()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }
}
