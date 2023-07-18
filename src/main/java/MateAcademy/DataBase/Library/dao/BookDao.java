package MateAcademy.DataBase.Library.dao;

import MateAcademy.DataBase.Library.models.Book;

public interface BookDao {
    Book create(Book book);

    Book get(Long id);

    boolean delete(Long id);

    Book update(Book book);
}
