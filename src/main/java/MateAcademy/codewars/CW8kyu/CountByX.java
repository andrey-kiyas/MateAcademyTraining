package MateAcademy.codewars.CW8kyu;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/5513795bd3fafb56c200049e/train/java
 */

public class CountByX {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBy(3, 7)));  // 3,6,9,12,15,18,21
        System.out.println(Arrays.toString(countBy(50, 5))); // 50,100,150,200,250
    }

    public static int[] countBy(int x, int n){
        int[] result = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += x;
            result[i] = sum;
        }
        return result;
    }
}
