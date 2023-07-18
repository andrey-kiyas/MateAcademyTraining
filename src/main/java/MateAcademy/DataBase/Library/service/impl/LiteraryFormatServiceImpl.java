package MateAcademy.DataBase.Library.service.impl;

import MateAcademy.DataBase.Library.dao.LiteraryFormatDao;
import MateAcademy.DataBase.Library.lib.Inject;
import MateAcademy.DataBase.Library.lib.Service;
import MateAcademy.DataBase.Library.models.LiteraryFormat;
import MateAcademy.DataBase.Library.service.LiteraryFormatService;
import java.util.List;

@Service
public class LiteraryFormatServiceImpl implements LiteraryFormatService {
    @Inject
    private LiteraryFormatDao literaryFormatDao;

    @Override
    public List<LiteraryFormat> getAll() {
        return literaryFormatDao.getAll();
    }

    @Override
    public LiteraryFormat create(LiteraryFormat format) {
        return literaryFormatDao.create(format);
    }

    @Override
    public LiteraryFormat get(Long id) {
        return literaryFormatDao.get(id);
    }

    @Override
    public LiteraryFormat update(LiteraryFormat format) {
        return literaryFormatDao.update(format);
    }

    @Override
    public boolean delete(Long id) {
        return literaryFormatDao.delete(id);
    }
}
