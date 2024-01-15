package MateAcademy.codewars.CW8kyu;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/5a34b80155519e1a00000009/train/java
 */

public class MultipleOfIndex {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(multipleOfIndex(new int[]{22, -6, 32, 82, 9, 25}))); // [-6, 32, 25]
        System.out.println(Arrays.toString(multipleOfIndex(new int[]{0, 2, 3, 6, 9})));         // [0, 2, 6]
    }

    public static int[] multipleOfIndex(int[] array) {
        int count = 0;

        // Подсчитываем количество элементов, которые соответствуют условиям
        for (int i = 1; i < array.length; i++) {
            if (array[i] % i == 0) {
                count++;
            }
        }

        // Включаем элемент с индексом 0 в результат, если он равен 0
        if (array[0] == 0) {
            count++;
        }

        // Создаем новый массив нужной длины и заполняем его подходящими элементами
        int[] result = new int[count];
        int index = 0;

        // Заполняем массив подходящими элементами
        if (array[0] == 0) {
            result[index++] = 0;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] % i == 0) {
                result[index++] = array[i];
            }
        }

        return result;
    }
}
