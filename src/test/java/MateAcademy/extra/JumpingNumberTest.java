package MateAcademy.extra;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class JumpingNumberTest {

    private static final Map<Integer, String> data = new HashMap<>();

    @BeforeClass
    public static void beforeClass() {
        data.put(1, "Jumping!!");
        data.put(9, "Jumping!!");
        data.put(11, "Not!!");
        data.put(12, "Jumping!!");
        data.put(43, "Jumping!!");
        data.put(24, "Not!!");
        data.put(454, "Jumping!!");
        data.put(123456789, "Jumping!!");
        data.put(890, "Not!!");
        data.put(5676546, "Not!!");
    }

    @Test
    public void isJumping_numbersToTest() {
        for (Map.Entry<Integer, String> entry : data.entrySet()) {
            int input = entry.getKey();
            String expected = entry.getValue();
            String actual = JumpingNumber.isJumping(input);
            Assert.assertEquals(String.format("Your method should return %s for the number %d",
                    expected, input), expected, actual);
        }
    }

}
