package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * sdsadsadsadsa
 */

public class LC1291SequentialDigits {
    public static void main(String[] args) {
        System.out.println(sequentialDigits(100, 300));    // [123, 234]
        System.out.println(sequentialDigits(1000, 13000)); // [1234, 2345, 3456, 4567, 5678, 6789, 12345]
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String sample = "123456789";

        for (int length = 2; length <= 9; length++) {
            for (int start = 0; start <= sample.length() - length; start++) {
                String sub = sample.substring(start, start + length);
                int num = Integer.parseInt(sub);

                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }

        return result;
    }
}
