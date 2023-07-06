package MateAcademy.collections.ArrayPractice;

import java.util.Arrays;

public class matrixAddition {
    public static void main(String[] args) {
//        int[][] a = new int[][]{{1, 2, 3},{3, 2, 1}};
//        int[][] b = new int[][]{{3, 2, 1},{1, 2, 3}};

//|1 2 3 4|     |2 2 1 2|     |1+2 2+2 3+1 4+2|     |3 4 4 6|
//|3 2 1 2|  +  |3 2 3 1|  =  |3+3 2+2 1+3 2+1|  =  |6 4 4 3|
//|1 1 1 0|     |1 1 3 5|     |1+1 1+1 1+3 0+5|     |2 2 4 5|

        int[][] a = new int[][]{{1, 2, 3, 4}, {3, 2, 1, 2}, {1, 1, 1, 0}};
        int[][] b = new int[][]{{2, 2, 1, 2}, {3, 2, 3, 1}, {1, 1, 3, 5}};
        System.out.println(Arrays.deepToString(addMatrix(a, b)));
    }

    public static int[][] addMatrix(int[][] first, int[][] second) {
        // write your code here
        int[][] result = new int[first.length][second[0].length];
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[i].length; j++) {
                result[i][j] = first[i][j] + second[i][j];
            }
        }
        return result;
    }
}
