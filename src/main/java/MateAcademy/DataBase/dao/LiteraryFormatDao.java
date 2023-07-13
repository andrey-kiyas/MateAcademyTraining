package MateAcademy.DataBase.dao;

import MateAcademy.DataBase.models.LiteraryFormat;
import java.util.List;

public interface LiteraryFormatDao {
    List<LiteraryFormat> getAll();

    LiteraryFormat create(LiteraryFormat format);

    boolean delete(Long id);
}
