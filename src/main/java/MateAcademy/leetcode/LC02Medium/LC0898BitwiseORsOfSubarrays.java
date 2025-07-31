package MateAcademy.leetcode.LC02Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/bitwise-ors-of-subarrays
 */

public class LC0898BitwiseORsOfSubarrays {
    public static void main(String[] args) {
        System.out.println(subarrayBitwiseORs(new int[]{0}));       // 1
        System.out.println(subarrayBitwiseORs(new int[]{1, 1, 2})); // 3
        System.out.println(subarrayBitwiseORs(new int[]{1, 2, 4})); // 6
    }

    public static int subarrayBitwiseORs(int[] arr) {
        Set<Integer> resultSet = new HashSet<>();
        Set<Integer> prev = new HashSet<>();

        for (int num : arr) {
            Set<Integer> current = new HashSet<>();
            current.add(num);

            for (int prevOr : prev) {
                current.add(prevOr | num);
            }

            resultSet.addAll(current);
            prev = current;
        }

        return resultSet.size();
    }
}
