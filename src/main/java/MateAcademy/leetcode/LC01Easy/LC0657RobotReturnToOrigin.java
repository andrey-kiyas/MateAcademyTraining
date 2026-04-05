package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/robot-return-to-origin
 */

public class LC0657RobotReturnToOrigin {
    public static void main(String[] args) {
        System.out.println(judgeCircle("UD")); // true
        System.out.println(judgeCircle("LL")); // false
    }

    public static boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'U') {
                y++;
            } else if (move == 'D') {
                y--;
            } else if (move == 'L') {
                x--;
            } else if (move == 'R') {
                x++;
            }
        }

        return x == 0 && y == 0;
    }
}
