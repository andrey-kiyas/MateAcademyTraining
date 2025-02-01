package MateAcademy.leetcode.medium;

public class LC0036ValidSudoku {

    public static void main(String[] args) {

        char[][] board1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        char[][] board2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board1)); // true
        System.out.println(isValidSudoku(board2)); // false

    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int rowCheck = 0, colCheck = 0, boxCheck = 0;

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !isValid(board[i][j], rowCheck)) return false;
                rowCheck += getBitForNum(board[i][j]);

                if (board[j][i] != '.' && !isValid(board[j][i], colCheck)) return false;
                colCheck += getBitForNum(board[j][i]);

                int row = 3 * (i / 3) + j / 3;
                int col = 3 * (i % 3) + j % 3;
                if (board[row][col] != '.' && !isValid(board[row][col], boxCheck)) return false;
                boxCheck += getBitForNum(board[row][col]);
            }
        }
        return true;
    }

    private static boolean isValid(char c, int check) {
        int num = c - '0';
        return (check / (int) Math.pow(10, num)) % 10 == 0;
    }

    private static int getBitForNum(char c) {
        return (int) Math.pow(10, c - '0');
    }

    public static boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < 9; i++) {
            int rowCheck = 0, colCheck = 0, boxCheck = 0;

            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if ((rowCheck / (int) Math.pow(10, num)) % 10 == 1) return false;
                    rowCheck += (int) Math.pow(10, num);
                }

                if (board[j][i] != '.') {
                    int num = board[j][i] - '0';
                    if ((colCheck / (int) Math.pow(10, num)) % 10 == 1) return false;
                    colCheck += (int) Math.pow(10, num);
                }

                int row = 3 * (i / 3) + j / 3;
                int col = 3 * (i % 3) + j % 3;
                if (board[row][col] != '.') {
                    int num = board[row][col] - '0';
                    if ((boxCheck / (int) Math.pow(10, num)) % 10 == 1) return false;
                    boxCheck += (int) Math.pow(10, num);
                }
            }
        }
        return true;
    }
}
