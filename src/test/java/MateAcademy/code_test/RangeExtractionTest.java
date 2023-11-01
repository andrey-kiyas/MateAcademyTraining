package MateAcademy.code_test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RangeExtractionTest {
    private static final Map<int[], String> data = new HashMap<>();

    @BeforeClass
    public static void beforeClass() {
        data.put(new int[]{1}, "1");
        data.put(new int[]{-4, -3}, "-4,-3");
        data.put(new int[]{1, 2, 3}, "1-3");
        data.put(new int[]{-3, 0, 7}, "-3,0,7");
        data.put(new int[]{-6, -3, -2, -1, 0, 1}, "-6,-3-1");
        data.put(new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20}, "-3--1,2,10,15,16,18-20");
        data.put(new int[]{-10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0}, "-10-0");
        data.put(new int[]{-1, 2, 4, 6, 8, 10, 13, 15, 17, 18, 20, 21, 23, 25, 27}, "-1,2,4,6,8,10,13,15,17,18,20,21,23,25,27");
        data.put(new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20},
                "-6,-3-1,3-5,7-11,14,15,17-20");
    }

    @Test
    public void extractRange_integersToRangedString() {
        for (Map.Entry<int[], String> entry : data.entrySet()) {
            int[] input = entry.getKey();
            String expected = entry.getValue();
            String actual = RangeExtraction.extractRange(input);
            Assert.assertEquals(String.format("Your method should return a string \"%s\" for the input array \"%s\"\n",
                    expected, Arrays.toString(input)), expected, actual);
        }
    }
}
