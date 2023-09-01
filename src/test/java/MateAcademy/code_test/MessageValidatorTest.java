package MateAcademy.code_test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class MessageValidatorTest {
    private static final Map<String, Boolean> data = new HashMap<>();

    @BeforeClass
    public static void beforeClass() {
        data.put("", true);
        data.put("0", true);
        data.put("1a", true);
        data.put("2aa3bb", false);
        data.put("2aa3bbb", true);
        data.put("3hey5hello2hi5", false);
        data.put("code4hello5", false);
        data.put("3hey5hello2hi", true);
        data.put("11mateacademy", true);
        data.put("1a2bb3ccc4dddd5eeeeee", false);
    }

    @Test
    public void isValidMessage_checkString() {
        for (Map.Entry<String, Boolean> entry : data.entrySet()) {
            String input = entry.getKey();
            boolean expected = entry.getValue();
            boolean actual = MessageValidator.isValidMessage(input);
            Assert.assertEquals(String.format("Your method should return %b for the input string \"%s\"\n",
                    expected, input), expected, actual);
        }
    }
}
