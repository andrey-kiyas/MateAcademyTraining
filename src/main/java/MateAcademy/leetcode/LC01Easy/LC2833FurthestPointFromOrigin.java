package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/furthest-point-from-origin
 */

public class LC2833FurthestPointFromOrigin {
    public static void main(String[] args) {
        System.out.println(furthestDistanceFromOrigin("L_RL__R")); // 3
        System.out.println(furthestDistanceFromOrigin("_R__LL_")); // 5
        System.out.println(furthestDistanceFromOrigin("_______")); // 7
    }

    public static int furthestDistanceFromOrigin(String moves) {
        int countL = 0;
        int countR = 0;
        int countUnderline = 0;

        for (char move : moves.toCharArray()) {
            if (move == 'L') {
                countL++;
            } else if (move == 'R') {
                countR++;
            } else {
                countUnderline++;
            }
        }

        return Math.abs(countL - countR) + countUnderline;
    }
}
