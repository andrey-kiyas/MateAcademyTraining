package MateAcademy.leetcode.LC03Hard;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/number-of-paths-with-max-score
 */

public class LC1301NumberOfPathsWithMaxScore {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(pathsWithMaxScore(List.of("E23", "2X2", "12S")))); // [7, 1]
        System.out.println(Arrays.toString(pathsWithMaxScore(List.of("E12", "1X1", "21S")))); // [4, 2]
        System.out.println(Arrays.toString(pathsWithMaxScore(List.of("E11", "XXX", "11S")))); // [0, 0]
    }

    public static int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;

        int[][] maxSum = new int[n][n];
        int[][] paths = new int[n][n];

        for (int[] row : maxSum) {
            Arrays.fill(row, -1);
        }

        maxSum[n - 1][n - 1] = 0;
        paths[n - 1][n - 1] = 1;

        int[][] dirs = {{1, 0}, {0, 1}, {1, 1}};

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'X' || board.get(i).charAt(j) == 'S') {
                    continue;
                }

                int bestSum = -1;
                int bestPaths = 0;

                for (int[] dir : dirs) {
                    int prevI = i + dir[0];
                    int prevJ = j + dir[1];

                    if (prevI < n && prevJ < n && maxSum[prevI][prevJ] != -1) {
                        if (maxSum[prevI][prevJ] > bestSum) {
                            bestSum = maxSum[prevI][prevJ];
                            bestPaths = paths[prevI][prevJ];
                        } else if (maxSum[prevI][prevJ] == bestSum) {
                            bestPaths = (bestPaths + paths[prevI][prevJ]) % MOD;
                        }
                    }
                }

                if (bestSum != -1) {
                    char currChar = board.get(i).charAt(j);
                    int currValue = (currChar == 'E') ? 0 : (currChar - '0');

                    maxSum[i][j] = bestSum + currValue;
                    paths[i][j] = bestPaths;
                }
            }
        }

        if (maxSum[0][0] == -1) {
            return new int[]{0, 0};
        }

        return new int[]{maxSum[0][0], paths[0][0]};
    }
}
