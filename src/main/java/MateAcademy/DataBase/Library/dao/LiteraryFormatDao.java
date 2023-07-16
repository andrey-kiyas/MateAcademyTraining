package MateAcademy.DataBase.Library.dao;

import MateAcademy.DataBase.Library.models.LiteraryFormat;
import java.util.List;

public interface LiteraryFormatDao {
    List<LiteraryFormat> getAll();

    LiteraryFormat create(LiteraryFormat format);

    boolean delete(Long id);
}
