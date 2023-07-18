package MateAcademy.DataBase.Library.dao.impl;

import MateAcademy.DataBase.Library.dao.BookDao;
import MateAcademy.DataBase.Library.lib.Dao;
import MateAcademy.DataBase.Library.models.Author;
import MateAcademy.DataBase.Library.models.Book;
import MateAcademy.DataBase.Library.models.LiteraryFormat;
import MateAcademy.DataBase.Library.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Dao
public class BookDaoImpl implements BookDao {
    @Override
    public Book create(Book book) {
        String insertRequest = "INSERT INTO `books` (`tittle`, `price`, `literary_format_id`) VALUES (?, ?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement createBookStatement = connection
                     .prepareStatement(insertRequest, Statement.RETURN_GENERATED_KEYS)
        ) {
            createBookStatement.setString(1, book.getTittle());
            createBookStatement.setBigDecimal(2, book.getPrice());
            createBookStatement.setLong(3, book.getFormat().getId());
            createBookStatement.executeUpdate();
            ResultSet generatedKeys = createBookStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                Long id = generatedKeys.getObject(1, Long.class);
                book.setId(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't insert book to DB", e);
        }
        insertAuthors(book);
        return book;
    }

    private void insertAuthors(Book book){
        String insertAuthorsQuery = "INSERT INTO books_authors (book_id, author_id) VALUES (?, ?);";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement addAuthorToBookStatement = connection
                     .prepareStatement(insertAuthorsQuery)
        ) {
            addAuthorToBookStatement.setLong(1, book.getId());
            for (Author author : book.getAuthors()) {
                addAuthorToBookStatement.setLong(2, author.getId());
                addAuthorToBookStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't insert authors to book" + book, e);
        }
    }

    @Override
    public Book get(Long id) {
        String selectRequest = "SELECT b.id as book_id, tittle, price, lf.id as literary_format_id," +
                " format FROM books b JOIN literary_formats lf on b.literary_format_id = lf.id " +
                "WHERE b.id = ? AND b.is_deleted = FALSE;";
        Book book = null;
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement getBookStatement = connection
                     .prepareStatement(selectRequest)
        ) {
            getBookStatement.setLong(1, id);
            ResultSet resultSet = getBookStatement.executeQuery();
            if (resultSet.next()) {
                book = parseBookWithLiteraryFormatResultSet(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Can't get book from DB", e);
        }
        if (book != null) {
            book.setAuthors(getAuthorsForBook(id));
        }
        return book;
    }

    @Override
    public boolean delete(Long bookId) {
        String deleteBookQuery = "UPDATE books SET is_deleted = TRUE WHERE id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement softDeleteBookStatement = connection
                     .prepareStatement(deleteBookQuery)
        ) {
            softDeleteBookStatement.setLong(1, bookId);
            int numberOfDeletedRows = softDeleteBookStatement.executeUpdate();
            return numberOfDeletedRows != 0;
        } catch (SQLException e) {
            throw new RuntimeException("Can't delete book with id: " + bookId, e);
        }
    }

    @Override
    public Book update(Book book) {
        // 1. update books fields
        // 2. delete all relations in book_authors table where bookId = book.getId()
        // 3. add new relations to the book_authors table
        return book;
    }

    private Book parseBookWithLiteraryFormatResultSet(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setTittle(resultSet.getString("tittle"));
        book.setPrice(resultSet.getBigDecimal("price"));
        LiteraryFormat literaryFormat = new LiteraryFormat();
        literaryFormat.setId(resultSet.getObject("literary_format_id", Long.class));
        literaryFormat.setFormat(resultSet.getString("format"));
        book.setFormat(literaryFormat);
        book.setId(resultSet.getObject("book_id", Long.class));
        return book;
    }

    private List<Author> getAuthorsForBook(Long bookId) {
        String getAuthorsForBookRequest = "SELECT t1.id, t1.name, t1.lastName FROM authors t1 " +
                "JOIN books_authors t2 on t1.id = t2.author_id JOIN books t3 " +
                "on t3.id = t2.book_id WHERE t3.id = ?;";
        try (Connection connection = ConnectionUtil.getConnection();
             PreparedStatement getAllAuthorsStatement = connection
                     .prepareStatement(getAuthorsForBookRequest)
        ) {
            getAllAuthorsStatement.setLong(1, bookId);
            ResultSet resultSet = getAllAuthorsStatement.executeQuery();
            List<Author> authors = new ArrayList<>();
            while (resultSet.next()) {
                authors.add(parseAuthorsFromResultSet(resultSet));
            }
            return authors;
        } catch (SQLException e) {
            throw new RuntimeException("Can't get book authors", e);
        }
    }

    private Author parseAuthorsFromResultSet(ResultSet resultSet) throws SQLException {
        Author author = new Author();
        author.setId(resultSet.getObject("id", Long.class));
        author.setName(resultSet.getString("name"));
        author.setLastName(resultSet.getString("lastName"));
        return author;
    }
}
