package MateAcademy.DataBase;

import MateAcademy.DataBase.dao.LiteraryFormatDaoImpl;

public class MainDB {
    public static void main(String[] args) {
//        ADD
//        LiteraryFormat format = new LiteraryFormat();
//        format.setFormat("fairy");

//        CREATE
        LiteraryFormatDaoImpl literaryFormatDao = new LiteraryFormatDaoImpl();
//        LiteraryFormat savedFormat = literaryFormatDao.create(format);
//        System.out.println(savedFormat);

//        DELETE
//        System.out.println(literaryFormatDao.delete(savedFormat.getId()));
//        System.out.println(literaryFormatDao.delete(4L));

//        PRINT
//        List<LiteraryFormat> allFormats = literaryFormatDao.getAll();
//        for (LiteraryFormat format : allFormats) {
//            System.out.println(format);
//        }
        literaryFormatDao.getAll().forEach(System.out::println);
    }
}
