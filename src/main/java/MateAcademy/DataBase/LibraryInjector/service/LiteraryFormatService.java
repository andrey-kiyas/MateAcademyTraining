package MateAcademy.DataBase.LibraryInjector.service;

import MateAcademy.DataBase.LibraryInjector.models.LiteraryFormat;
import java.util.List;

public interface LiteraryFormatService {
    List<LiteraryFormat> getAll();

    LiteraryFormat create(LiteraryFormat format);

    LiteraryFormat get(Long id);

    LiteraryFormat update(LiteraryFormat format);

    boolean delete(Long id);
}
