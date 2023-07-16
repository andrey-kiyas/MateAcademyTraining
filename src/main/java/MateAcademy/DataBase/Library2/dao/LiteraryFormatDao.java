package MateAcademy.DataBase.Library2.dao;

import MateAcademy.DataBase.Library2.models.LiteraryFormat;
import java.util.List;

public interface LiteraryFormatDao {
    List<LiteraryFormat> getAll();

    LiteraryFormat create(LiteraryFormat format);

    boolean delete(Long id);

    LiteraryFormat get(Long id);

    LiteraryFormat update(LiteraryFormat format);
}
