package MateAcademy.code_test;

/**
 * Реалізуй метод createPassphrase(), який приймає рядок phrase та ціле позитивне
 * число shift. Метод повинен перетворити передану фразу на супер-секретний пароль,
 * використовуючи такі правила:
 * -------------------------------------------------------------------------------
 * 1 - Змісти кожну букву на задане число shift. Обов'язково врахуй круговий зсув,
 * так що 'z' перетворюється на 'a' при зміщенні вперед.
 * 2 - Заміни кожну цифру на її доповнення до 9.
 * 3 - Усі символи, які не є буквами або цифрами, можна залишити як є.
 * 4 - Будь-яка буква з непарним індексом повинна бути малою, тоді як будь-яка
 * буква з парним індексом - великою.
 * 5 - Переверни отриманий результат.
 * -------------------------------------------------------------------------------
 * https://mate.academy/daily-tasks/60ef7a21-80b7-4779-8e2a-9f6b00c8085c?testTaskSlug=java_create_passphrase&section=practice
 * -------------------------------------------------------------------------------
 */

public class Passphrase {
    public static void main(String[] args) {
        String phrase = "ENCODE ME";
        int shift = 5;
        String expected = "Jr jItHsJ";
        if (expected.equals(createPassphrase(phrase, shift))) {
            System.out.println("Yes! Correct!");
        } else {
            System.out.println("No! Error!");
        }
    }

    public static String createPassphrase(String phrase, int shift) {
        // write code here
        StringBuilder result = new StringBuilder();
        int digit = 0;
        char letter = 'a';
        boolean isUpper = true;
        char[] charArray = phrase.toLowerCase().toCharArray();
        for (char ch : charArray) {
            if (Character.isDigit(ch)) {
                digit = Character.getNumericValue(ch);
                result.append(9 - digit);
            } else if (Character.isLetter(ch)) {
                letter = ch;
                for (int i = 0; i < shift; i++) {
                    letter++;
                    if (Character.getNumericValue(letter) == -1) {
                        letter = 'a';
                    }
                }
                if (isUpper) {
                    result.append(Character.toUpperCase(letter));
                }
                if (!isUpper) {
                    result.append(letter);
                }
            } else {
                result.append(ch);
            }
            isUpper = !isUpper;
        }
        return String.valueOf(result.reverse());
    }

    public static String createPassphrase2(String phrase, int shift) {
        return null;
    }
}
