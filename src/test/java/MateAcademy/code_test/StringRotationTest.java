package MateAcademy.code_test;

import org.junit.Assert;
import org.junit.Test;

public class StringRotationTest {
    @Test
    public void calculateRotations_oneRotation() {
        String string1 = "hello";
        String string2 = "ohell";
        int expected = 1;
        int actual = StringRotation.calculateRotations(string1, string2);
        Assert.assertEquals(String.format("The number of rotations is %d for the input strings \"%s\" and \"%s\"\n",
                expected, string1, string2), expected, actual);
    }

    @Test
    public void calculateRotations_zeroRotation() {
        String string1 = "mate";
        String string2 = "mate";
        int expected = 0;
        int actual = StringRotation.calculateRotations(string1, string2);
        Assert.assertEquals(String.format("The number of rotations is %d for the input strings \"%s\" and \"%s\"\n",
                expected, string1, string2), expected, actual);
    }

    @Test
    public void calculateRotations_twoRotations() {
        String string1 = "isn't";
        String string2 = "'tisn";
        int expected = 2;
        int actual = StringRotation.calculateRotations(string1, string2);
        Assert.assertEquals(String.format("The number of rotations is %d for the input strings \"%s\" and \"%s\"\n",
                expected, string1, string2), expected, actual);
    }

    @Test
    public void calculateRotations_forUppercaseStrings() {
        String string1 = "M`(QTdP";
        String string2 = "TdPM`(Q";
        int expected = 3;
        int actual = StringRotation.calculateRotations(string1, string2);
        Assert.assertEquals(String.format("The number of rotations is %d for the input strings \"%s\" and \"%s\"\n",
                expected, string1, string2), expected, actual);
    }

    @Test
    public void calculateRotations_forNumbersInString() {
        String string1 = "123456789!@#$%^&*( )qwerty";
        String string2 = "9!@#$%^&*( )qwerty12345678";
        int expected = 18;
        int actual = StringRotation.calculateRotations(string1, string2);
        Assert.assertEquals(String.format("The number of rotations is %d for the input strings \"%s\" and \"%s\"\n",
                expected, string1, string2), expected, actual);
    }

    @Test
    public void calculateRotations_invalidRotations() {
        String string1 = "dog";
        String string2 = "god";
        int expected = -1;
        int actual = StringRotation.calculateRotations(string1, string2);
        Assert.assertEquals(String.format("The number of rotations is %d for the input strings \"%s\" and \"%s\"\n",
                expected, string1, string2), expected, actual);
    }
}
