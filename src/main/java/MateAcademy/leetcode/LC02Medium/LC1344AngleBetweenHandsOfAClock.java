package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/angle-between-hands-of-a-clock
 */

public class LC1344AngleBetweenHandsOfAClock {
    public static void main(String[] args) {
        System.out.println(angleClock(12, 30)); // 165.0
        System.out.println(angleClock(3, 30));  // 75.0
        System.out.println(angleClock(3, 15));  // 7.5
    }

    public static double angleClock(int hour, int minutes) {
        double minuteAngle = minutes * 6.0;

        double hourAngle = (hour % 12) * 30.0 + minutes * 0.5;

        double angle = Math.abs(hourAngle - minuteAngle);

        if (angle > 180.0) {
            angle = 360.0 - angle;
        }

        return angle;
    }
}
