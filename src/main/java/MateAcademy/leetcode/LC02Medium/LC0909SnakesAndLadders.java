package MateAcademy.leetcode.LC02Medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/snakes-and-ladders
 */

public class LC0909SnakesAndLadders {
    public static void main(String[] args) {
        int[][] board1 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        System.out.println(snakesAndLadders(board1)); // 4

        int[][] board2 = {
                {-1, -1},
                {-1, 3}
        };
        System.out.println(snakesAndLadders(board2)); // 1
    }

    public static int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.remove();

                if (curr == n * n) return moves;

                for (int roll = 1; roll <= 6; roll++) {
                    int next = curr + roll;
                    if (next > n * n) continue;

                    int[] coords = getCoordinates(next, n);
                    int row = coords[0], col = coords[1];

                    if (board[row][col] != -1) {
                        next = board[row][col];
                    }

                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private static int[] getCoordinates(int num, int n) {
        int row = n - 1 - (num - 1) / n;
        int col = (num - 1) % n;
        if (((n - 1 - row) % 2) == 1) {
            col = n - 1 - col;
        }
        return new int[]{row, col};
    }
}
