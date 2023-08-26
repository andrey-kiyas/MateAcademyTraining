package MateAcademy.code_test;

import org.junit.Assert;
import java.util.HashMap;
import java.util.Map;
import org.junit.BeforeClass;
import org.junit.Test;

public class CubicNumbersTest {
    private static final Map<String, String> data = new HashMap<>();

    @BeforeClass
    public static void beforeClass() {
        data.put("407", "407 407 Lucky");
        data.put("   371    ", "371 371 Lucky");
        data.put("abaab153xyxyxxy", "153 153 Lucky");
        data.put("lll1lll371llll385llll407lll", "1 371 407 779 Lucky");
        data.put("37092", "370 370 Lucky");
        data.put("4073701", "407 370 1 778 Lucky");
        data.put("9324 0 -3923", "0 0 Lucky");
        data.put("1371", "1 1 Lucky");
        data.put("408", "Unlucky");
        data.put("90407", "Unlucky");
        data.put("qwerty&()", "Unlucky");
        data.put("    ", "Unlucky");
        data.put("", "Unlucky");
    }

    @Test
    public void findCubicNumbers_stringInput() {
        for (Map.Entry<String, String> entry : data.entrySet()) {
            String input = entry.getKey();
            String expected = entry.getValue();
            String actual = CubicNumbers.findCubicNumbers(input);
            Assert.assertEquals(String.format("The result should be \"%s\" for the input string \"%s\"\n",
                    expected, input), expected, actual);
        }
    }
}