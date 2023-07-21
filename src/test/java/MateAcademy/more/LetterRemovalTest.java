package MateAcademy.more;

import org.junit.Assert;
import org.junit.Test;

public class LetterRemovalTest {
    @Test
    public void removeLetter_zeroCharacters() {
        String string = "hello";
        int n = 0;
        String actual = LetterRemoval.removeLetter(string, n);
        String expected = "hello";
        Assert.assertEquals(String.format("The result should be the same as input string \"%s\" when n = 0\n", string),
                expected, actual);
    }

    @Test
    public void removeLetter_oneCharacter() {
        String string = "a";
        int n = 1;
        String actual = LetterRemoval.removeLetter(string, n);
        String expected = "";
        Assert.assertEquals(String.format("The result should be \"%s\" for the input string \"%s\" and n = 1\n",
                expected, string), expected, actual);
    }

    @Test
    public void removeLetter_twoCharacters() {
        String string = "abracadabra";
        int n = 2;
        String actual = LetterRemoval.removeLetter(string, n);
        String expected = "brcadabra";
        Assert.assertEquals(String.format("The result should be \"%s\" for the input string \"%s\" and n = 2\n",
                expected, string), expected, actual);
    }

    @Test
    public void removeLetter_threeCharacters() {
        String string = "aabc";
        int n = 3;
        String actual = LetterRemoval.removeLetter(string, n);
        String expected = "c";
        Assert.assertEquals(String.format("The result should be \"%s\" for the input string \"%s\" and n = 3\n",
                expected, string), expected, actual);
    }

    @Test
    public void removeLetter_sixCharacters() {
        String string = "mateacademy";
        int n = 6;
        String actual = LetterRemoval.removeLetter(string, n);
        String expected = "mtemy";
        Assert.assertEquals(String.format("The result should be \"%s\" for the input string \"%s\" and n = 6\n",
                expected, string), expected, actual);
    }

    @Test
    public void removeLetter_tenCharacters() {
        String string = "abcdefghijklmnopqrstuvwxyz";
        int n = 10;
        String actual = LetterRemoval.removeLetter(string, n);
        String expected = "klmnopqrstuvwxyz";
        Assert.assertEquals(String.format("The result should be \"%s\" for the input string \"%s\" and n = 10\n",
                expected, string), expected, actual);
    }

    @Test
    public void removeLetter_allCharacters() {
        String string = "abracadabra";
        int n = 100;
        String actual = LetterRemoval.removeLetter(string, n);
        String expected = "";
        Assert.assertEquals(String.format("The result should be \"%s\" for the input string \"%s\" and n = 100\n",
                expected, string), expected, actual);
    }
}
