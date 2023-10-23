package MateAcademy.code_test.CommonSubsequence;

import org.junit.Assert;
import org.junit.Test;

public class CommonSubsequenceTest {
    @Test
    public void getLongestCommonSubsequence_forStringsWithNoCommons() {
        String string1 = "ab";
        String string2 = "cd";
        String expected = "";
        String actual = CommonSubsequence.getLongestCommonSubsequence(string1, string2);
        Assert.assertEquals("Your method should return an empty string if there is no common subsequence\n",
                expected, actual);
    }

    @Test
    public void getLongestCommonSubsequence_forEqualStrings() {
        String string1 = "a";
        String string2 = "a";
        String expected = "a";
        String actual = CommonSubsequence.getLongestCommonSubsequence(string1, string2);
        Assert.assertEquals(String.format("The result should be \"%s\" for string1 = \"%s\" and string2 = \"%s\"\n",
                expected, string1, string2), expected, actual);
    }

    @Test
    public void getLongestCommonSubsequence_forStringsWithDifferentLengths() {
        String string1 = "anothertest";
        String string2 = "notatest";
        String expected = "nottest";
        String actual = CommonSubsequence.getLongestCommonSubsequence(string1, string2);
        Assert.assertEquals(String.format("The result should be \"%s\" for string1 = \"%s\" and string2 = \"%s\"\n",
                expected, string1, string2), expected, actual);
    }

    @Test
    public void getLongestCommonSubsequence_forStringsWithNumbers() {
        String string1 = "11702674";
        String string2 = "65845694";
        String expected = "64";
        String actual = CommonSubsequence.getLongestCommonSubsequence(string1, string2);
        Assert.assertEquals(String.format("The result should be \"%s\" for string1 = \"%s\" and string2 = \"%s\"\n",
                expected, string1, string2), expected, actual);
    }

    @Test
    public void getLongestCommonSubsequence_forStringsWithNumbersAndLetters() {
        String string1 = "1m3p5t7r9z2k4h6g8j";
        String string2 = "y0m1p3t5r7z9k1h3g5";
        String expected = "mptrzkhg";
        String actual = CommonSubsequence.getLongestCommonSubsequence(string1, string2);
        Assert.assertEquals(String.format("The result should be \"%s\" for string1 = \"%s\" and string2 = \"%s\"\n",
                expected, string1, string2), expected, actual);
    }
}
