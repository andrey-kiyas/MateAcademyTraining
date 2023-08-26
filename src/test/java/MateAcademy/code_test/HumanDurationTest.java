package MateAcademy.code_test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HumanDurationTest {
    private static final Map<Integer, String> data = new HashMap<>();

    @BeforeClass
    public static void beforeClass() {
        data.put(0, "now");
        data.put(1, "1 second");
        data.put(7, "7 seconds");
        data.put(60, "1 minute");
        data.put(61, "1 minute and 1 second");
        data.put(145, "2 minutes and 25 seconds");
        data.put(3599, "59 minutes and 59 seconds");
        data.put(3600, "1 hour");
        data.put(3601, "1 hour and 1 second");
        data.put(3661, "1 hour, 1 minute and 1 second");
        data.put(70396, "19 hours, 33 minutes and 16 seconds");
        data.put(86400, "1 day");
        data.put(86401, "1 day and 1 second");
        data.put(86530, "1 day, 2 minutes and 10 seconds");
        data.put(15552000, "180 days");
        data.put(30000000, "347 days, 5 hours and 20 minutes");
        data.put(31536000, "1 year");
        data.put(40242488, "1 year, 100 days, 18 hours, 28 minutes and 8 seconds");
        data.put(94878183, "3 years, 3 days, 3 hours, 3 minutes and 3 seconds");
    }

    @Test
    public void formatDuration_numberOfSeconds() {
        for (Map.Entry<Integer, String> entry : data.entrySet()) {
            int input = entry.getKey();
            String expected = entry.getValue();
            String actual = HumanDuration.formatDuration(input);
            Assert.assertEquals(String.format("The result should be \"%s\" for the %d seconds\n",
                    expected, input), expected, actual);
        }
    }
}
