package MateAcademy.codewars.CW7kyu;

import java.util.Arrays;
import java.util.List;

public class Testing123 {

    public static void main(String[] args) {
        System.out.println(number(Arrays.asList("a", "b", "c")));
    }

    public static List<String> number(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, i + 1 + ": " + lines.get(i));
        }
        return lines;
    }
}
