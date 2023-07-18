package MateAcademy.DataBase.Library.service.impl;

import MateAcademy.DataBase.Library.dao.BookDao;
import MateAcademy.DataBase.Library.lib.Inject;
import MateAcademy.DataBase.Library.lib.Service;
import MateAcademy.DataBase.Library.models.Book;
import MateAcademy.DataBase.Library.service.BookService;

@Service
public class BookServiceImpl implements BookService {
    @Inject
    private BookDao bookDao;

    @Override
    public Book create(Book book) {
        return bookDao.create(book);
    }

    @Override
    public Book get(Long id) {
        return bookDao.get(id);
    }
}
