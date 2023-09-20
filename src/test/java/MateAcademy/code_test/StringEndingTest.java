package MateAcademy.code_test;

import org.junit.Assert;
import org.junit.Test;

public class StringEndingTest {
    @Test
    public void isEndsWith_checkVowels() {
        String string = "samurai";
        String ending = "ai";
        boolean expected = true;
        boolean actual = StringEnding.isEndsWith(string, ending);
        Assert.assertEquals(String.format("The result should be %b for string \"%s\" and ending \"%s\"\n",
                expected, string, ending), expected, actual);
    }

    @Test
    public void isEndsWith_checkConsonants() {
        String string = "abc";
        String ending = "abcd";
        boolean expected = false;
        boolean actual = StringEnding.isEndsWith(string, ending);
        Assert.assertEquals(String.format("The result should be %b for string \"%s\" and ending \"%s\"\n",
                expected, string, ending), expected, actual);
    }

    @Test
    public void isEndsWith_checkFalseSymbols() {
        String string = ":-)";
        String ending = ":-(";
        boolean expected = false;
        boolean actual = StringEnding.isEndsWith(string, ending);
        Assert.assertEquals(String.format("The result should be %b for string \"%s\" and ending \"%s\"\n",
                expected, string, ending), expected, actual);
    }

    @Test
    public void isEndsWith_checkTrueSymbols() {
        String string = "!@#$%^&*() :-)";
        String ending = ":-)";
        boolean expected = true;
        boolean actual = StringEnding.isEndsWith(string, ending);
        Assert.assertEquals(String.format("The result should be %b for string \"%s\" and ending \"%s\"\n",
                expected, string, ending), expected, actual);
    }

    @Test
    public void isEndsWith_checkEqualStrings() {
        String string = "mate";
        String ending = "mate";
        boolean expected = true;
        boolean actual = StringEnding.isEndsWith(string, ending);
        Assert.assertEquals(String.format("The result should be %b for string \"%s\" and ending \"%s\"\n",
                expected, string, ending), expected, actual);
    }

    @Test
    public void isEndsWith_checkNumbers() {
        String string = "12345";
        String ending = "5";
        boolean expected = true;
        boolean actual = StringEnding.isEndsWith(string, ending);
        Assert.assertEquals(String.format("The result should be %b for string \"%s\" and ending \"%s\"\n",
                expected, string, ending), expected, actual);
    }

    @Test
    public void isEndsWith_checkEmptyString() {
        String string = "";
        String ending = "true";
        boolean expected = false;
        boolean actual = StringEnding.isEndsWith(string, ending);
        Assert.assertEquals(String.format("The result should be %b for string \"%s\" and ending \"%s\"\n",
                expected, string, ending), expected, actual);
    }

    @Test
    public void isEndsWith_checkEmptyEnding() {
        String string = "string";
        String ending = "";
        boolean expected = true;
        boolean actual = StringEnding.isEndsWith(string, ending);
        Assert.assertEquals(String.format("The result should be %b for string \"%s\" and ending \"%s\"\n",
                expected, string, ending), expected, actual);
    }
}
