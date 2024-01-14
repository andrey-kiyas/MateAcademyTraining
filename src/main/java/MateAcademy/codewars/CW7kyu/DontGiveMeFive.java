package MateAcademy.codewars.CW7kyu;

/**
 * https://www.codewars.com/kata/5813d19765d81c592200001a/train/java
 */

public class DontGiveMeFive {

    public static void main(String[] args) {
        System.out.println(dontGiveMeFive(4, 17)); // 12
        System.out.println(dontGiveMeFive(1, 9));  // 8
    }

    public static int dontGiveMeFive(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (!containsDigit(i, 5)) {
                count++;
            }
        }
        return count;
    }

    private static boolean containsDigit(int number, int digit) {
        while (number != 0) {
            int remainder = number % 10;
            if (remainder == digit) {
                return true;
            }
            number /= 10;
        }
        return false;
    }
}
