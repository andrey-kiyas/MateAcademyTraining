package MateAcademy.leetcode.LC01Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/rank-transform-of-an-array
 */

public class LC1331RankTransformOfAnArray {
    public static void main(String[] args) {
        int[] arr1 = {40, 10, 20, 30};
        System.out.println(Arrays.toString(arrayRankTransform(arr1))); // [4, 1, 2, 3]

        int[] arr2 = {100, 100, 100};
        System.out.println(Arrays.toString(arrayRankTransform(arr2))); // [1, 1, 1]

        int[] arr3 = {37, 12, 28, 9, 100, 56, 80, 5, 12};
        System.out.println(Arrays.toString(arrayRankTransform(arr3))); // [5, 3, 4, 2, 8, 6, 7, 1, 3]
    }

    public static int[] arrayRankTransform(int[] arr) {
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int currentRank = 1;

        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, currentRank);
                currentRank++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }

        return arr;
    }
}
