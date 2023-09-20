package MateAcademy.code_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;

public class PaginationHelperTest {
    @Test
    public void pageCount_countPages() {
        List<Character> data = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f');
        int itemsPerPage = 4;
        PaginationHelper<Character> helper = new PaginationHelper<>(data, itemsPerPage);
        int actual = helper.pageCount();
        Assert.assertEquals(String.format("The method `pageCount()` should return %d for the collection that contains " +
                "%d elements and with %d items per page\n", 2, data.size(), itemsPerPage), 2, actual);
    }

    @Test
    public void itemCount_countItems() {
        List<String> data = Arrays.asList("mate", "academy", "teaches", "to code");
        int itemsPerPage = 1;
        PaginationHelper<String> helper = new PaginationHelper<>(data, itemsPerPage);
        int actual = helper.itemCount();
        Assert.assertEquals(String.format("The method `itemCount()` should return %d for the collection that contains " +
                "%d elements and with %d item per page\n", 4, data.size(), itemsPerPage), 4, actual);
    }

    @Test
    public void pageItemCount_onTheFirstPage() {
        List<Integer> data = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int itemsPerPage = 2;
        PaginationHelper<Integer> helper = new PaginationHelper<>(data, itemsPerPage);
        int actual = helper.pageItemCount(0);
        Assert.assertEquals(String.format("The method `pageItemCount(0)` should return %d for the collection that contains " +
                "%d elements and with %d item per page\n", 2, data.size(), itemsPerPage), 2, actual);
    }

    @Test
    public void pageItemCount_onTheLastPage() {
        List<Character> data = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f');
        int itemsPerPage = 4;
        PaginationHelper<Character> helper = new PaginationHelper<>(data, itemsPerPage);
        int actual = helper.pageItemCount(1);
        Assert.assertEquals(String.format("The method `pageItemCount(1)` should return %d for the collection that contains " +
                "%d elements and with %d item per page\n", 2, data.size(), itemsPerPage), 2, actual);
    }

    @Test
    public void pageItemCount_invalidPage() {
        List<Character> data = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f');
        int itemsPerPage = 4;
        PaginationHelper<Character> helper = new PaginationHelper<>(data, itemsPerPage);
        int actual = helper.pageItemCount(2);
        Assert.assertEquals(String.format("The method `pageItemCount(2)` should return %d for the collection that contains " +
                "%d elements and with %d item per page\n", -1, data.size(), itemsPerPage), -1, actual);
    }

    @Test
    public void pageIndex_zeroBasedIndex() {
        List<Character> data = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f');
        int itemsPerPage = 4;
        PaginationHelper<Character> helper = new PaginationHelper<>(data, itemsPerPage);
        int actual = helper.pageIndex(5);
        Assert.assertEquals(String.format("The method `pageIndex(5)` should return %d for the collection that contains " +
                "%d elements and with %d item per page\n", 1, data.size(), itemsPerPage), 1, actual);
    }

    @Test
    public void pageIndex_zeroPage() {
        List<Character> data = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f');
        int itemsPerPage = 4;
        PaginationHelper<Character> helper = new PaginationHelper<>(data, itemsPerPage);
        int actual = helper.pageIndex(2);
        Assert.assertEquals(String.format("The method `pageIndex(2)` should return %d for the collection that contains " +
                "%d elements and with %d item per page\n", 0, data.size(), itemsPerPage), 0, actual);
    }

    @Test
    public void pageIndex_invalidPage() {
        List<Character> data = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f');
        int itemsPerPage = 4;
        PaginationHelper<Character> helper = new PaginationHelper<>(data, itemsPerPage);
        int actual = helper.pageIndex(-10);
        Assert.assertEquals(String.format("The method `pageIndex(-10)` should return %d for the collection that contains " +
                "%d elements and with %d item per page\n", -1, data.size(), itemsPerPage), -1, actual);
    }


//    private List<Character> collection = List.of('a', 'b', 'c', 'd', 'e', 'f');
//    private PaginationHelper<Character> helper = new PaginationHelper<>(collection, 4);
//
//    @Test @Order(4) @DisplayName("Test pageIndex()")
//    void testPageIndex() {
//        assertEquals( 1, helper.pageIndex(5), "pageIndex is returning incorrect value for index 5");
//        assertEquals( 0, helper.pageIndex(2), "pageIndex is returning incorrect value for index 2");
//        assertEquals(-1, helper.pageIndex(20), "pageIndex is returning incorrect value for index 20");
//        assertEquals(-1, helper.pageIndex(-10), "pageIndex is returning incorrect value for index -10");
//    }
//
//    @Test
//    @Order(5)
//    @DisplayName("Empty collection")
//    void emptyCollection() {
//        PaginationHelper<?> empty = new PaginationHelper<>(List.of(), 10);
//        assertEquals(0, empty.itemCount(), "itemCount is returning incorrect value");
//        assertEquals(0, empty.pageCount(), "pageCount is returning incorrect value");
//        assertEquals(-1, empty.pageIndex(0), "pageIndex(0) called when there was an empty collection");
//        assertEquals(-1, empty.pageIndex(1), "pageIndex(1) called when there was an empty collection");
//        assertEquals(-1, empty.pageIndex(-1), "pageIndex(-1) called when there was an empty collection");
//        assertEquals(-1, empty.pageItemCount(0), "pageItemCount is returning incorrect value for page 0");
//        assertEquals(-1, empty.pageItemCount(1), "pageItemCount is returning incorrect value for page 1");
//    }
}
