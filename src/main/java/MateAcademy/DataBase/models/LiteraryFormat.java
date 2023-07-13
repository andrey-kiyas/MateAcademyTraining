package MateAcademy.DataBase.models;

public class LiteraryFormat {
    private Long id;
    private String title;

    public Long getId() {
        return id;
    }

    public LiteraryFormat setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public LiteraryFormat setTitle(String title) {
        this.title = title;
        return this;
    }

    @Override
    public String toString() {
        return "LiteraryFormat{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
