package MateAcademy.DataBase.Library.service;

import MateAcademy.DataBase.Library.models.Book;

public interface BookService {
    Book create(Book book);

    Book get(Long id);
}
