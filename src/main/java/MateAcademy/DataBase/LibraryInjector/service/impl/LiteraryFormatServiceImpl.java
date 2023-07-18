package MateAcademy.DataBase.LibraryInjector.service.impl;

import MateAcademy.DataBase.LibraryInjector.dao.LiteraryFormatDao;
import MateAcademy.DataBase.LibraryInjector.lib.Inject;
import MateAcademy.DataBase.LibraryInjector.lib.Service;
import MateAcademy.DataBase.LibraryInjector.models.LiteraryFormat;
import MateAcademy.DataBase.LibraryInjector.service.LiteraryFormatService;
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
//        return null;
    }

    @Override
    public LiteraryFormat update(LiteraryFormat format) {
//        return null;
        return literaryFormatDao.update(format);
    }

    @Override
    public boolean delete(Long id) {
//        return false;
        return literaryFormatDao.delete(id);
    }
}
