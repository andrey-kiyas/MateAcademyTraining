package MateAcademy.DataBase.Library.models;

import java.math.BigDecimal;
import java.util.List;

public class Book {
    private Long id;
    private String tittle;
    private BigDecimal price;
    private LiteraryFormat format;
    private List<Author> authors;

    public Long getId() {
        return id;
    }

    public Book setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTittle() {
        return tittle;
    }

    public Book setTittle(String tittle) {
        this.tittle = tittle;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Book setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LiteraryFormat getFormat() {
        return format;
    }

    public Book setFormat(LiteraryFormat format) {
        this.format = format;
        return this;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Book setAuthors(List<Author> authors) {
        this.authors = authors;
        return this;
    }

    @Override
    public String toString() {
        return "Book{"
                + "id=" + id
                + ", tittle='" + tittle + '\''
                + ", price=" + price
                + ", format=" + format
                + '}';
    }
}
