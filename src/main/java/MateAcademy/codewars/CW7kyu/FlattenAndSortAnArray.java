package MateAcademy.codewars.CW7kyu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://www.codewars.com/kata/57ee99a16c8df7b02d00045f/train/java
 */

public class FlattenAndSortAnArray {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(flattenAndSort(new int[][]{{3, 2, 1}, {7, 9, 8}, {6, 4, 5}})));                              // [1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(Arrays.toString(flattenAndSort(new int[][] {{111, 999}, {222}, {333}, {444}, {888}, {777}, {666}, {555}}))); // [111, 222, 333, 444, 555, 666, 777, 888, 999]
        System.out.println(Arrays.toString(flattenAndSort(new int[][] {{1, 3, 5} ,{100}, {2, 4, 6}})));                                 // [1, 2, 3, 4, 5, 6, 100]
    }

    public static int[] flattenAndSort(int[][] array) {
        return Arrays.stream(array)
                .flatMapToInt(Arrays::stream)
                .sorted()
                .toArray();
    }

    public static int[] flattenAndSort2(int[][] array) {
        List<Integer> arrayList = new ArrayList<>();
        for (int[] row : array) {
            for (int num : row) {
                arrayList.add(num);
            }
        }
        Collections.sort(arrayList);
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }
}
