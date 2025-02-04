package MateAcademy.leetcode.medium;

import java.util.Stack;

/**
 * https://leetcode.com/problems/sum-of-subarray-minimums
 */

public class LC0907SumOfSubarrayMinimums {

    public static void main(String[] args) {
        System.out.println(sumSubarrayMins(new int[]{3, 1, 2, 4}));        // Вывод: 17
        System.out.println(sumSubarrayMins(new int[]{11, 81, 94, 43, 3})); // Вывод: 444
    }

    public static int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;
        int[] left = new int[n]; // left[i] - индекс ближайшего элемента слева, меньшего arr[i]
        int[] right = new int[n]; // right[i] - индекс ближайшего элемента справа, меньшего arr[i]

        // Используем стек для хранения индексов элементов в порядке возрастания
        // и обновляем left и right для каждого элемента
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear(); // Очищаем стек для использования в правом проходе

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long result = 0;

        // Для каждого элемента arr[i], добавляем arr[i] * количество подмассивов, в которых arr[i] - минимум
        for (int i = 0; i < n; i++) {
            result = (result + (long) arr[i] * (i - left[i]) * (right[i] - i) % MOD) % MOD;
        }

        return (int) result;
    }
}
