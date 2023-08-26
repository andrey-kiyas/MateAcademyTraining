package MateAcademy.code_test.SupermarketQueue;

import java.util.Arrays;

public class SupermarketQueue {
    public static void main(String[] args) {
        int[] customers = new int[]{29, 18, 6, 23, 25, 29, 24, 17, 16, 13, 17, 7, 21, 7, 11, 18, 26, 25, 1, 18, 29, 16, 26};
        int checkout = 7;
        System.out.println(calculateTotalTime(customers, checkout));
    }

    public static int calculateTotalTime(int[] customers, int checkout) {
        // write code here
        int[] result = new int[checkout];
        if (customers.length == 0) {
            return 0;
        } else if (checkout == 1) {
            return Arrays.stream(customers).sum();
        }
        for (int i = 0; i < customers.length; i++) {
            result[0] += customers[i];
            Arrays.sort(result);
        }
        return result[checkout - 1];
    }
}
