package MateAcademy.codewars.CW7kyu;

/**
 * https://www.codewars.com/kata/55caf1fd8063ddfa8e000018/train/java
 */

public class ArithmeticProgression {

    public static void main(String[] args) {
        System.out.println(arithmeticSequenceElements(1, 2, 5)); // "1, 3, 5, 7, 9"
        System.out.println(arithmeticSequenceElements(1, 0, 5)); // "1, 1, 1, 1, 1"
        System.out.println(arithmeticSequenceElements(100, -10, 10)); // "100, 90, 80, 70, 60, 50, 40, 30, 20, 10"
    }

    public static String arithmeticSequenceElements(int a, int d, long n) {
        // Solution goes here
        StringBuilder builder = new StringBuilder(String.valueOf(a));
        int sum = a;
        for (int i = 1; i < n; i++) {
            sum += d;
            builder.append(", ").append(sum);
        }
        return String.valueOf(builder);
    }
}
