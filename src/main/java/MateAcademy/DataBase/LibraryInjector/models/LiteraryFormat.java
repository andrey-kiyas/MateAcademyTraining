package MateAcademy.DataBase.LibraryInjector.models;

public class LiteraryFormat {
    private Long id;
    private String format;
    private boolean isDeleted;

    public Long getId() {
        return id;
    }

    public LiteraryFormat setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public LiteraryFormat setFormat(String format) {
        this.format = format;
        return this;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public LiteraryFormat setDeleted(boolean deleted) {
        this.isDeleted = deleted;
        return this;
    }

    @Override
    public String toString() {
        return "LiteraryFormat{" +
                "id=" + id +
                ", format='" + format + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
