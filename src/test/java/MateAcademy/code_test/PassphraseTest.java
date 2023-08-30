package MateAcademy.code_test;

import org.junit.Assert;
import org.junit.Test;

public class PassphraseTest {
    @Test
    public void createPassphrase_oneWord() {
        String phrase = "HELLO";
        int shift = 1;
        String expected = "PmMfI";
        Assert.assertEquals(String.format("Method should return the passphrase \"%s\" if phrase is \"%s\" and shift = %d\n",
                expected, phrase, shift), expected, Passphrase.createPassphrase(phrase, shift));
    }

    @Test
    public void createPassphrase_twoWords() {
        String phrase = "ENCODE ME";
        int shift = 5;
        String expected = "Jr jItHsJ";
        Assert.assertEquals(String.format("Method should return the passphrase \"%s\" if phrase is \"%s\" and shift = %d\n",
                expected, phrase, shift), expected, Passphrase.createPassphrase(phrase, shift));
    }

    @Test
    public void createPassphrase_numbersOnly() {
        String phrase = "3958728";
        int shift = 9;
        String expected = "1721406";
        Assert.assertEquals(String.format("Method should return the passphrase \"%s\" if phrase is \"%s\" and shift = %d\n",
                expected, phrase, shift), expected, Passphrase.createPassphrase(phrase, shift));
    }

    @Test
    public void createPassphrase_specialCharsOnly() {
        String phrase = "%^#@()_+_==+=*^<>?";
        int shift = 9;
        String expected = "?><^*=+==_+_)(@#^%";
        Assert.assertEquals(String.format("Method should return the passphrase \"%s\" if phrase is \"%s\" and shift = %d\n",
                expected, phrase, shift), expected, Passphrase.createPassphrase(phrase, shift));
    }

    @Test
    public void createPassphrase_wordsAndnumbers() {
        String phrase = "MAY THE 4CE B3 W1TH Y0U";
        int shift = 4;
        String expected = "Y9C Lx8a 6F Ig5 IlX CeQ";
        Assert.assertEquals(String.format("Method should return the passphrase \"%s\" if phrase is \"%s\" and shift = %d\n",
                expected, phrase, shift), expected, Passphrase.createPassphrase(phrase, shift));
    }

    @Test
    public void createPassphrase_wordsAndSpecialChars() {
        String phrase = "DON'T REUSE THIS PASSPHRASE!";
        int shift = 17;
        String expected = "!VjRiYgJjRg jZyK VjLvI K'EfU";
        Assert.assertEquals(String.format("Method should return the passphrase \"%s\" if phrase is \"%s\" and shift = %d\n",
                expected, phrase, shift), expected, Passphrase.createPassphrase(phrase, shift));
    }

    @Test
    public void createPassphrase_wordsNumbersAndSpecialChars1() {
        String phrase = "W!TH GR8 P0W3R C0M3S GR8 RESPONS1B1L1TY...";
        int shift = 12;
        String expected = "...Kf8x8n8eZaBeQd 1Ds e6y9o d6i9b 1Ds tF!I";
        Assert.assertEquals(String.format("Method should return the passphrase \"%s\" if phrase is \"%s\" and shift = %d\n",
                expected, phrase, shift), expected, Passphrase.createPassphrase(phrase, shift));
    }

    @Test
    public void createPassphrase_wordsNumbersAndSpecialChars2() {
        String phrase = "1'LL 8E BACK.";
        int shift = 21;
        String expected = ".fXvW Z1 gG'8";
        Assert.assertEquals(String.format("Method should return the passphrase \"%s\" if phrase is \"%s\" and shift = %d\n",
                expected, phrase, shift), expected, Passphrase.createPassphrase(phrase, shift));
    }

    @Test
    public void createPassphrase_wordsNumbersAndSpecialChars3() {
        String phrase = "T0 1NFINI1TY & BEYOND!";
        int shift = 21;
        String expected = "!YiJtZw & tO8DiDaI8 9O";
        Assert.assertEquals(String.format("Method should return the passphrase \"%s\" if phrase is \"%s\" and shift = %d\n",
                expected, phrase, shift), expected, Passphrase.createPassphrase(phrase, shift));
    }

    @Test
    public void createPassphrase_emptyString() {
        String phrase = "";
        int shift = 3;
        String expected = "";
        Assert.assertEquals(String.format("Method should return the passphrase \"%s\" if phrase is \"%s\" and shift = %d\n",
                expected, phrase, shift), expected, Passphrase.createPassphrase(phrase, shift));
    }
}
