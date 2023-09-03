package MateAcademy.code_test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

public class MaxRotateTest {
    private static final Map<Long, Long> data = new HashMap<>();

    @BeforeClass
    public static void beforeClass() {
        data.put(56789L, 68957L);
        data.put(69418307L, 94183076L);
        data.put(38458215L, 85821534L);
        data.put(195881031L, 988103115L);
        data.put(896219342L, 962193428L);
        data.put(758655697L, 758655697L);
        data.put(8097466318L, 8097466318L);
        data.put(3390939445L, 3909394453L);
        data.put(10046991286L, 10046991286L);
    }

    @Test
    public void getMaxRotations_checkNumbers() {
        for (Map.Entry<Long, Long> entry : data.entrySet()) {
            long input = entry.getKey();
            long expected = entry.getValue();
            long actual = MaxRotate.getMaxRotations(input);
            Assert.assertEquals(String.format("The result should be %d for the input number %d\n",
                    expected, input), expected, actual);
        }
    }
}
