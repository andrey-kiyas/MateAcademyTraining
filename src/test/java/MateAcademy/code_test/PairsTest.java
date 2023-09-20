package MateAcademy.code_test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PairsTest {
    private static final Map<int[], Integer> data = new HashMap<>();

    @BeforeClass
    public static void beforeClass() {
        data.put(new int[]{3}, 0);
        data.put(new int[]{7, 7}, 1);
        data.put(new int[]{4, 8, 8}, 1);
        data.put(new int[]{-3, -3, -3}, 1);
        data.put(new int[]{2, -2, 2, -2}, 2);
        data.put(new int[]{1, 4, 4, 4, 1}, 2);
        data.put(new int[]{6, 8, -9, -6, -8, 9}, 0);
        data.put(new int[]{11, 11, 11, 11, 11, 11}, 3);
        data.put(new int[]{3, 8, 16, 16, 16, 3, 3, 3, 3, 7, 8, 8, 7, 7, 7, 16, 3, 8, 16, 16, 7, 8, 3, 3, 3}, 11);
        data.put(new int[]{}, 0);
    }

    @Test
    public void findPairs_numberArray() {
        for (Map.Entry<int[], Integer> entry : data.entrySet()) {
            int[] input = entry.getKey();
            int expected = entry.getValue();
            int actual = Pairs.findPairs(input);
            Assert.assertEquals(String.format("The method should return %d for the input array %s\n",
                    expected, Arrays.toString(input)), expected, actual);
        }
    }
}
