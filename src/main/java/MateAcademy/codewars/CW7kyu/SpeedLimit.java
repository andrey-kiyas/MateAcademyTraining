package MateAcademy.codewars.CW7kyu;

/**
 * https://www.codewars.com/kata/635a7827bafe03708e3e1db6/train/java
 */

public class SpeedLimit {
    public static void main(String[] args) {
        System.out.println(speedLimit(60, new int[]{80, 70, 60}));       // 0
        System.out.println(speedLimit(90, new int[]{80}));               // 100
        System.out.println(speedLimit(100, new int[]{110, 100, 80}));    // 250
        System.out.println(speedLimit(130, new int[]{140, 130, 100}));   // 500
        System.out.println(speedLimit(110, new int[]{120, 110, 100}));   // 100
        System.out.println(speedLimit(220, new int[]{120, 110, 100}));   // 1500
        System.out.println(speedLimit(100, new int[]{70, 80, 90, 100})); // 850
        System.out.println(speedLimit(100, new int[]{110, 100, 80}));    // 250
    }

    public static int speedLimit(final int speed, final int[] signals) {
        //Write here your code :D
        int fineAmount = 0;
        for (int signalSpeed : signals) {
            int speedDifference = speed - signalSpeed;
            if (speedDifference >= 10 && speedDifference <= 19) {
                fineAmount += 100;
            } else if (speedDifference >= 20 && speedDifference <= 29) {
                fineAmount += 250;
            } else if (speedDifference >= 30) {
                fineAmount += 500;
            }
        }
        return fineAmount;
    }
}
