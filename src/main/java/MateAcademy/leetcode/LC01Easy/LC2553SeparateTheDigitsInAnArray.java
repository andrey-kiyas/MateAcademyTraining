package MateAcademy.leetcode.LC01Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/separate-the-digits-in-an-array
 */

public class LC2553SeparateTheDigitsInAnArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(separateDigits(new int[]{13, 25, 83, 77})));
        // [1, 3, 2, 5, 8, 3, 7, 7]
        System.out.println(Arrays.toString(separateDigits(new int[]{7, 1, 3, 9})));
        // [7, 1, 3, 9]
    }

    public static int[] separateDigits(int[] nums) {
        List<Integer> resultList = new ArrayList<>();

        for (int num : nums) {
            String s = String.valueOf(num);
            for (int i = 0; i < s.length(); i++) {
                resultList.add(s.charAt(i) - '0');
            }
        }

        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }
}
