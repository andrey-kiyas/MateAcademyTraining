package MateAcademy.collections.HashMap.GetAuthorByBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        Author author1 = new Author("Andrew", "Ukraine");
        Author author2 = new Author("Sergey", "Ukraine");

        Book book11 = new Book("Title Andrew 11", 2020);
        Book book12 = new Book("Title Andrew 12", 2021);

        Book book21 = new Book("Title Sergey 21", 2015);
        Book book22 = new Book("Title Sergey 22", 2016);

        Map<Author, List<Book>> authorBooks = new HashMap<>();

        authorBooks.put(author1, List.of(book11, book12));
        authorBooks.put(author2, List.of(book21, book22));

        System.out.println(GetAuthorByBook.getAuthorNameByBookTitle(authorBooks, "Title Sergey 21"));
//        System.out.println(GetAuthorByBook.getAuthorNameByBookTitle(authorBooks, "USA"));
    }
}
