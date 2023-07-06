package MateAcademy.collections.HashMap.GetAuthorByBook;

import java.util.List;
import java.util.Map;

public class GetAuthorByBook {
    public static String getAuthorNameByBookTitle(Map<Author, List<Book>> authorBooks, String bookTitle) {
        //write your code here
        for (Map.Entry<Author, List<Book>> entry : authorBooks.entrySet()) {
            for (Book book : entry.getValue()) {
                if (book.getTitle().equals(bookTitle)) {
                    return entry.getKey().getName();
                }
            }
        }
        return null;
    }
}
