package MateAcademy.code_test;

import java.util.Arrays;

public class SquareMatrixMultiplication {
  public static void main(String[] args) {

    System.out.println(Arrays.deepToString(multiplySquareMatrices(new int[][]{{1, 2}, {3, 4}}, new int[][]{{5, 6}, {7, 8}})));

  }

  public static int[][] multiplySquareMatrices(int[][] a, int[][] b) {
    // write code here
    if (a.length == 0 || b.length == 0) {
      System.err.println("Эти матрицы пустые");
      return new int[][]{};
    }
    if (a[0].length != b.length) {
      System.err.println("Эти матрицы нельзя перемножить");
      return null;
    }
    final var matrixM = new int[a.length][b[0].length];
    for (var i = 0; i < matrixM.length; i++) {
      for (var j = 0; j < matrixM[0].length; j++) {
        matrixM[i][j] = 0;
        for (var k = 0; k < a[0].length; k++) {
          matrixM[i][j] += a[i][k] * b[k][j];
        }
      }
    }
    return matrixM;
  }
}