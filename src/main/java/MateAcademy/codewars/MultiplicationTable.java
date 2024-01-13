package MateAcademy.codewars;

import java.util.Arrays;

public class MultiplicationTable {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(multiplicationTable(6)));
    }

    public static int[][] multiplicationTable(int n) {
        int[][] table = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}
