package MateAcademy.code_test.ConvertListToString;

//import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListConverterTest {
    @Test
    public void convertListToString_checkFirstList() {
        Node list = new Node(1, new Node(2, new Node(3)));
        String expected = "1 -> 2 -> 3 -> null";
        Assert.assertEquals(String.format("The result should be \"%s\" for the linked list\n",
                expected), expected, LinkedListConverter.convertListToString(list));
    }

    @Test
    public void convertListToString_checkSecondList() {
        Node list = new Node(0, new Node(1, new Node(4, new Node(9, new Node(16)))));
        String expected = "0 -> 1 -> 4 -> 9 -> 16 -> null";
        Assert.assertEquals(String.format("The result should be \"%s\" for the linked list\n",
                expected), expected, LinkedListConverter.convertListToString(list));
    }

    @Test
    public void convertListToString_checkNull() {
        Assert.assertEquals(String.format("The result should be \"%s\" for the linked list\n",
                "null"), "null", LinkedListConverter.convertListToString(null));
    }
}
