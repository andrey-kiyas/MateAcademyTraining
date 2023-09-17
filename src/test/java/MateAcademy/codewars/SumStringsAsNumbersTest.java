package MateAcademy.codewars;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
class SumStringsAsNumbersTest {
    @Test
    void test() {
        assertEquals("579", SumStringsAsNumbers.sumStrings("123", "456"));
    }
}
