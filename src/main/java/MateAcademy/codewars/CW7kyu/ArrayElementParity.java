package MateAcademy.codewars.CW7kyu;

/**
 * https://www.codewars.com/kata/5a092d9e46d843b9db000064/train/java
 */

public class ArrayElementParity {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, -1, 2, -2, 3}));    // 3
        System.out.println(solve(new int[]{1, -1, 2, -2, 3, 3})); // 3
    }

    public static int solve(int[] arr) {
        for (int num : arr) {
            boolean found = false;

            for (int other : arr) {
                if (num == -other) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return num;
            }
        }
        return 0;
    }
}
