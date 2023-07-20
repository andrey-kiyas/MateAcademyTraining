package MateAcademy.more;

import org.junit.Assert;
import org.junit.Test;

public class BackwardsPrimesTest {
    @Test
    public void getBackwardsPrimes_fromOneToOne() {
        long start = 1;
        long end = 1;
        String expected = "";
        Assert.assertEquals(String.format("The result should be \"%s\" for the start = %d and end = %d\n",
                expected, start, end), expected, BackwardsPrimes.getBackwardsPrimes(start, end));
    }

    @Test
    public void getBackwardsPrimes_fromOneToThirteen() {
        long start = 1;
        long end = 13;
        String expected = "13";
        Assert.assertEquals(String.format("The result should be \"%s\" for the start = %d and end = %d\n",
                expected, start, end), expected, BackwardsPrimes.getBackwardsPrimes(start, end));
    }

    @Test
    public void getBackwardsPrimes_fromThirteenToThirtyOne() {
        long start = 13;
        long end = 31;
        String expected = "13 17 31";
        Assert.assertEquals(String.format("The result should be \"%s\" for the start = %d and end = %d\n",
                expected, start, end), expected, BackwardsPrimes.getBackwardsPrimes(start, end));
    }

    @Test
    public void getBackwardsPrimes_fromOneToHundred() {
        long start = 1;
        long end = 100;
        String expected = "13 17 31 37 71 73 79 97";
        Assert.assertEquals(String.format("The result should be \"%s\" for the start = %d and end = %d\n",
                expected, start, end), expected, BackwardsPrimes.getBackwardsPrimes(start, end));
    }

    @Test
    public void getBackwardsPrimes_bigNumbers() {
        long start = 9900;
        long end = 10000;
        String expected = "9923 9931 9941 9967";
        Assert.assertEquals(String.format("The result should be \"%s\" for the start = %d and end = %d\n",
                expected, start, end), expected, BackwardsPrimes.getBackwardsPrimes(start, end));
    }

    @Test
    public void getBackwardsPrimes_largeNumbers() {
        long start = 700000008;
        long end = 700000050;
        String expected = "700000031";
        Assert.assertEquals(String.format("The result should be \"%s\" for the start = %d and end = %d\n",
                expected, start, end), expected, BackwardsPrimes.getBackwardsPrimes(start, end));
    }
}
