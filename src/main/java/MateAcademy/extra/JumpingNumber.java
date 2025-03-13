package MateAcademy.extra;

/**
 * Реалізуй метод isJumping(), який приймає додатне ціле число number і повертає рядок "Jumping!!", якщо кожна
 * цифра в числі відрізняється від сусідньої на 1. Якщо ці умова не виконується, потрібно повернути рядок "Not!!".
 *
 * Примітки:
 *
 * Різниця між 9 та 0 не вважається 1;
 * Усі одноцифрові числа вважаються "Jumping!!".
 * Приклади:
 *
 * isJumping(8) ==> "Jumping!!"
 * isJumping(57) ==> "Not!!"
 * isJumping(34) ==> "Jumping!!"
 * isJumping(232321) ==> "Jumping!!"
 * isJumping(90) ==> "Not!!"
 */

public class JumpingNumber {
    public static void main(String[] args) {
        System.out.println(isJumping(9));   // Jumping!!
        System.out.println(isJumping(12));  // Jumping!!
        System.out.println(isJumping(890)); // Not!!
    }

    public static String isJumping(int number) {
        String temp = Integer.toString(number);
        char[] digits = temp.toCharArray();
        for (int i = 0; i < digits.length - 1; i++) {
            if (Math.abs(digits[i + 1] - digits[i]) != 1) {
                return "Not!!";
            }
        }
        return "Jumping!!";
    }

    public static String isJumping2(int number) {
        String temp = Integer.toString(number);
        char[] numberInt = temp.toCharArray();

        for (int i = 0; i < numberInt.length - 1; i++) {
            if (Math.abs(numberInt[i + 1] - numberInt[i]) != 1) {
                return "Not!!";
            }
        }
        return "Jumping!!";
    }
}
