package MateAcademy.code_test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ExtraPerfectNumbersTest {
    private static final Map<Integer, int[]> data = new HashMap<>();

    @BeforeClass
    public static void beforeClass() {
        data.put(3, new int[]{1, 3});
        data.put(5, new int[]{1, 3, 5});
        data.put(8, new int[]{1, 3, 5, 7});
        data.put(28, new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27});
        data.put(39, new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39});
    }

    @Test
    public void getExtraPerfectNumbers_checkTheRange() {
        for (Map.Entry<Integer, int[]> entry : data.entrySet()) {
            int input = entry.getKey();
            int[] expected = entry.getValue();
            int[] actual = ExtraPerfectNumbers.getExtraPerfectNumbers(input);
            Assert.assertEquals(String.format("The array of extra perfect numbers should be \"%s\" for the input number %d",
                    Arrays.toString(expected), input), Arrays.toString(expected), Arrays.toString(actual));
        }
    }
}
