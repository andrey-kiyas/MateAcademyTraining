package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/lexicographical-numbers
 */

public class LC0386LexicographicalNumbers {
    public static void main(String[] args) {
        System.out.println(lexicalOrder(13)); // [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(lexicalOrder(2));  // [1, 2]
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        int current = 1;

        for (int i = 0; i < n; i++) {
            result.add(current);

            if (current * 10 <= n) {
                current *= 10;
            } else {
                if (current >= n) current /= 10;
                current++;

                while (current % 10 == 0) {
                    current /= 10;
                }
            }
        }

        return result;
    }
}
