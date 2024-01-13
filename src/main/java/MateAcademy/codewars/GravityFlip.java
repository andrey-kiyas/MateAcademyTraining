package MateAcademy.codewars;

import java.util.Arrays;


public class GravityFlip {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(flip('R', new int[]{3, 2, 1, 2})));
        System.out.println(Arrays.toString(flip('L', new int[]{1, 4, 5, 3, 5})));
    }

    public static int[] flip(char dir, int[] arr) {
        if (dir == 'R') {
            Arrays.sort(arr);
        } else if (dir == 'L') {
            Arrays.sort(arr);
            reverseArray(arr);
        }
        return arr;
    }

    public static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }
}
