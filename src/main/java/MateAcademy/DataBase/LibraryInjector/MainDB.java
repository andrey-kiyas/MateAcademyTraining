package MateAcademy.DataBase.LibraryInjector;

import MateAcademy.DataBase.LibraryInjector.service.LiteraryFormatService;
import MateAcademy.DataBase.LibraryInjector.util.Injector;

public class MainDB {
    private static Injector injector = Injector.getInstance("MateAcademy.DataBase.Library2");

    public static void main(String[] args) {
        LiteraryFormatService literaryFormatService = (LiteraryFormatService)
                injector.getInstance(LiteraryFormatService.class);

//        LiteraryFormatDao literaryFormatDao = new LiteraryFormatDaoImpl();
//        literaryFormatDao.getAll().forEach(System.out::println);

        literaryFormatService.getAll().forEach(System.out::println);
    }
}











//    public static void main(String[] args) {
//        LiteraryFormatDao literaryFormatDao = new LiteraryFormatDaoImpl();
////        NEW VALUE
//        LiteraryFormat format = new LiteraryFormat();
//        format.setFormat("fairy");
//
////        CREATE
//        LiteraryFormat savedFormat = literaryFormatDao.create(format);
//        System.out.println(savedFormat);
//
////        DELETE
//        System.out.println(literaryFormatDao.delete(savedFormat.getId()));
//        System.out.println(literaryFormatDao.delete(4L));
//
////        PRINT
////        List<LiteraryFormat> allFormats = literaryFormatDao.getAll();
////        for (LiteraryFormat format : allFormats) {
////            System.out.println(format);
////        }
//        literaryFormatDao.getAll().forEach(System.out::println);
//    }
