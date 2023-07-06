package MateAcademy.Java8.Part3;

import java.util.Optional;

/**
 * Завершите реализацию методов generateRandomOptional() и getOptionalValue().
 * <p>
 * generateRandomOptional() должен возвращать значение Optional, которое содержит
 * значение randomNumber, если randomNumber нечетное, или пустое значение Optional,
 * если randomNumber четное.
 * <p>
 * getOptionalValue() должен вызывать generateRandomOptional(), получать необязательный
 * параметр и возвращать его значение. Если значение отсутствует - должно быть выброшено
 * исключение NoSuchElementException.
 */

public class GetOptionalValue {
    public Integer getOptionalValue(int randomNumber) {
        Optional<Integer> optional = generateRandomOptional(randomNumber);
        //write your code here
        return optional.orElseThrow();
    }

    public Optional<Integer> generateRandomOptional(int randomNumber) {
        //write your code here
        if (randomNumber % 2 == 0) {
            return Optional.empty();
        }
        return Optional.of(randomNumber);
    }
}
