package MateAcademy.code_test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElementTest {
    private static final Map<int[], Integer> data = new HashMap<>();

    @BeforeClass
    public static void beforeClass() {
        data.put(new int[]{1, 2, 1}, 1);
        data.put(new int[]{4, 2, 2}, 2);
        data.put(new int[]{8, 7, 8, 8}, 8);
        data.put(new int[]{10, 5, 10, 10, 3}, 10);
        data.put(new int[]{34, 34, 34, 34, 34, 34}, 34);
        data.put(new int[]{-6, -2, -6, -6, -2, -6, -2, -2, -6}, -6);
        data.put(new int[]{0, -3, 0, 0, 0, 3, 0, 0, -3, -3, 0, 3, 3, 3}, 0);
    }

    @Test
    public void findMajor_numberArray() {
        for (Map.Entry<int[], Integer> entry : data.entrySet()) {
            int[] input = entry.getKey();
            int expected = entry.getValue();
            int actual = MajorityElement.findMajor(input);
            Assert.assertEquals(String.format("The method should return %d for the input array \"%s\"\n",
                    expected, Arrays.toString(input)), expected, actual);
        }
    }
}
