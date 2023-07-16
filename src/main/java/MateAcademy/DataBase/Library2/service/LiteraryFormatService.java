package MateAcademy.DataBase.Library2.service;

import MateAcademy.DataBase.Library2.models.LiteraryFormat;
import java.util.List;

public interface LiteraryFormatService {
    List<LiteraryFormat> getAll();

    LiteraryFormat create(LiteraryFormat format);

    LiteraryFormat get(Long id);

    LiteraryFormat update(LiteraryFormat format);

    boolean delete(Long id);
}
