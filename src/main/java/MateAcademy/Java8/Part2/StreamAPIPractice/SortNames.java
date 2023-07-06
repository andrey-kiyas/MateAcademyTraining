package MateAcademy.Java8.Part2.StreamAPIPractice;

import java.util.List;
import java.util.stream.Collectors;

/**
 *У тебе є список імен: List<String>. Твоє завдання: відсортуй імена за алфавітом
 * та поверни перші три з них після сортування.
 *
 * Наприклад:
 *
 * Input: List.of("Rick", "Jessie", "George", "Garold");
 * Result: List.of("Garold", "George", "Jessie");
 *
 * Input: List.of("Rick");
 * Result: List.of("Rick");
 */

public class SortNames { // 1
    public static List<String> sortNames(List<String> names) {
        return names.stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
    }
}
