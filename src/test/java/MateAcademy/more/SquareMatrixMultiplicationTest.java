package MateAcademy.more;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class SquareMatrixMultiplicationTest {
    public static final String ERROR_MSG = "Result should be %s for input values: %s and %s\n";

    @Test
    public void multiplySquareMatrices_emptyArrays() {
        Assert.assertArrayEquals("Result should be [[]] for input values: [[]] and [[]]\n",
                new int[][]{}, SquareMatrixMultiplication.multiplySquareMatrices(new int[][]{}, new int[][]{}));
    }

    @Test
    public void multiplySquareMatrices_singleElementArrays() {
        int[][] firstSquare = new int[][]{{2}};
        int[][] secondSquare = new int[][]{{2}};
        int[][] resultSquare = new int[][]{{4}};
        Assert.assertArrayEquals(String.format(ERROR_MSG, getStringRepresentation(resultSquare),
                getStringRepresentation(firstSquare), getStringRepresentation(secondSquare)),
                resultSquare, SquareMatrixMultiplication.multiplySquareMatrices(firstSquare, secondSquare));
    }

    @Test
    public void multiplySquareMatrices_twoElementArrays() {
        int[][] firstSquare = new int[][]{{9, 7}, {0, 1}};
        int[][] secondSquare = new int[][]{{1, 1}, {4, 12}};
        int[][] resultSquare = new int[][]{{37, 93}, {4, 12}};
        Assert.assertArrayEquals(String.format(ERROR_MSG, getStringRepresentation(resultSquare),
                getStringRepresentation(firstSquare), getStringRepresentation(secondSquare)),
                resultSquare, SquareMatrixMultiplication.multiplySquareMatrices(firstSquare, secondSquare));
    }

    @Test
    public void multiplySquareMatrices_threeElementArrays() {
        int[][] firstSquare = new int[][]{{1, 2, 3}, {3, 2, 1}, {2, 1, 3}};
        int[][] secondSquare = new int[][]{{4, 5, 6}, {6, 5, 4}, {4, 6, 5}};
        int[][] resultSquare = new int[][]{{28, 33, 29}, {28, 31, 31}, {26, 33, 31}};
        Assert.assertArrayEquals(String.format(ERROR_MSG, getStringRepresentation(resultSquare),
                getStringRepresentation(firstSquare), getStringRepresentation(secondSquare)),
                resultSquare, SquareMatrixMultiplication.multiplySquareMatrices(firstSquare, secondSquare));
    }

    @Test
    public void multiplySquareMatrices_fourElementArrays() {
        int[][] firstSquare = new int[][]{{5, 7, 9, 10}, {2, 3, 3, 8}, {8, 10, 2, 3}, {3, 3, 4, 8}};
        int[][] secondSquare = new int[][]{{3, 10, 12, 18}, {12, 1, 4, 9}, {9, 10, 12, 2}, {3, 12, 4, 10}};
        int[][] resultSquare = new int[][]{{210, 267, 236, 271}, {93, 149, 104, 149}, {171, 146, 172, 268}, {105, 169, 128, 169}};
        Assert.assertArrayEquals(String.format(ERROR_MSG, getStringRepresentation(resultSquare),
                getStringRepresentation(firstSquare), getStringRepresentation(secondSquare)),
                resultSquare, SquareMatrixMultiplication.multiplySquareMatrices(firstSquare, secondSquare));
    }

    @Test
    public void multiplySquareMatrices_fiveElementArrays() {
        int[][] firstSquare = new int[][]{{1, 4, 7, 9, 12}, {10, 7, 55, 12, 13}, {7, 81, 90, 17, 8}, {11, 2, 3, 1, 66}, {34, 52, 97, 8, 22}};
        int[][] secondSquare = new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] resultSquare = new int[][]{{498, 531, 564, 597, 630}, {1122, 1219, 1316, 1413, 1510}, {1923, 2126, 2329, 2532, 2735}, {1458, 1541, 1624, 1707, 1790}, {2003, 2216, 2429, 2642, 2855}};
        Assert.assertArrayEquals(String.format(ERROR_MSG, getStringRepresentation(resultSquare),
                getStringRepresentation(firstSquare), getStringRepresentation(secondSquare)),
                resultSquare, SquareMatrixMultiplication.multiplySquareMatrices(firstSquare, secondSquare));
    }

    private String getStringRepresentation(int[][] matrix) {
        String[] rowsToString = new String[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            rowsToString[i] = Arrays.toString(matrix[i]);
        }
        return Arrays.toString(rowsToString);
    };
}
