package MateAcademy.code_test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class AngleSumTest {
    private static final Map<Integer, Integer> data = new HashMap<>();

    @BeforeClass
    public static void beforeClass() {
        data.put(3, 180);
        data.put(4, 360);
        data.put(5, 540);
        data.put(6, 720);
        data.put(7, 900);
        data.put(9, 1260);
        data.put(15, 2340);
        data.put(20, 3240);
        data.put(51, 8820);
        data.put(69, 12060);
    }

    @Test
    public void getSumOfAngles_nSidedPolygon() {
        for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
            int input = entry.getKey();
            int expected = entry.getValue();
            int actual = AngleSum.getSumOfAngles(input);
            Assert.assertEquals(String.format("The total sum of angles should be %d for the polygon with %d sides\n",
                    expected, input), expected, actual);
        }
    }
}
