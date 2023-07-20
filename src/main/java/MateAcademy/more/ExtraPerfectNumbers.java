package MateAcademy.more;

import java.util.Arrays;

public class ExtraPerfectNumbers {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getExtraPerfectNumbers(29)));
    }

    public static int[] getExtraPerfectNumbers(int number) {
        // write code here
        int[] result = new int[(number + 1) / 2];
        for (int i = 0; i < result.length; i++) {
            result[i] = 1 + i * 2;
        }
        return result;
    }

    public static int[] getExtraPerfectNumbers2(int number) {
        int counter = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                continue;
            }
            counter++;
        }
        int[] result = new int[counter];
        int nextCounter = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                continue;
            }
            result[nextCounter] = i;
            nextCounter++;
        }
        return result;
    }
}
