package MateAcademy.DataBase.LibraryInjector.dao;

import MateAcademy.DataBase.LibraryInjector.models.LiteraryFormat;
import java.util.List;

public interface LiteraryFormatDao {
    List<LiteraryFormat> getAll();

    LiteraryFormat create(LiteraryFormat format);

    boolean delete(Long id);

    LiteraryFormat get(Long id);

    LiteraryFormat update(LiteraryFormat format);
}
