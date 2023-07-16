package MateAcademy.DataBase.Library;

import MateAcademy.DataBase.Library.dao.LiteraryFormatDao;
import MateAcademy.DataBase.Library.dao.LiteraryFormatDaoImpl;
import MateAcademy.DataBase.Library.models.LiteraryFormat;

public class MainDB {
    public static void main(String[] args) {
        LiteraryFormatDao literaryFormatDao = new LiteraryFormatDaoImpl();
//        NEW VALUE
        LiteraryFormat format = new LiteraryFormat();
        format.setFormat("fairy");

//        CREATE
        LiteraryFormat savedFormat = literaryFormatDao.create(format);
        System.out.println(savedFormat);

//        DELETE
        System.out.println(literaryFormatDao.delete(savedFormat.getId()));
        System.out.println(literaryFormatDao.delete(4L));

//        PRINT
//        List<LiteraryFormat> allFormats = literaryFormatDao.getAll();
//        for (LiteraryFormat format : allFormats) {
//            System.out.println(format);
//        }
        literaryFormatDao.getAll().forEach(System.out::println);
    }
}
