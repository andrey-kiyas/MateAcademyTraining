package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/champagne-tower
 */

public class LC799ChampagneTower {
    public static void main(String[] args) {
        System.out.println(champagneTower(1, 1, 1));           // 0.0
        System.out.println(champagneTower(2, 1, 1));           // 0.5
        System.out.println(champagneTower(100000009, 33, 17)); // 1.0
    }

    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[][] tower = new double[102][102];

        tower[0][0] = poured;

        for (int r = 0; r <= query_row; r++) {
            for (int c = 0; c <= r; c++) {
                if (tower[r][c] > 1.0) {
                    double excess = (tower[r][c] - 1.0) / 2.0;
                    tower[r + 1][c] += excess;
                    tower[r + 1][c + 1] += excess;
                }
            }
        }

        return Math.min(1.0, tower[query_row][query_glass]);
    }
}
