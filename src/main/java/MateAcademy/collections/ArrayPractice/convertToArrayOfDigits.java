package MateAcademy.collections.ArrayPractice;

import java.lang.reflect.Array;
import java.util.Arrays;

public class convertToArrayOfDigits {
    public static void main(String[] args) {
//        int num = 46156;
        int num = -123;
        System.out.println(Arrays.toString(toArrayOfDigits(num)));
    }

    public static int[] toArrayOfDigits(int n) {
        // write code here
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(Integer.toString(Math.abs(n)).toCharArray())).reverse();
        int[] result = new int[stringBuilder.length()];
        for (int i = 0; i < stringBuilder.length(); i++) {
            result[i] = Character.getNumericValue(stringBuilder.charAt(i));
        }
        return result;
    }
}
