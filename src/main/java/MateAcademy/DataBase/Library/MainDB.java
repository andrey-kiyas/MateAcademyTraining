package MateAcademy.DataBase.Library;


import MateAcademy.DataBase.Library.lib.Injector;
import MateAcademy.DataBase.Library.models.Book;
import MateAcademy.DataBase.Library.service.BookService;
import MateAcademy.DataBase.Library.service.LiteraryFormatService;

public class MainDB {
    private static Injector injector = Injector.getInstance("MateAcademy.DataBase.Library");

    public static void main(String[] args) {
//        LiteraryFormatService literaryFormatService = (LiteraryFormatService)
//                injector.getInstance(LiteraryFormatService.class);
        BookService bookService = (BookService)
                injector.getInstance(BookService.class);

        Book tomJerryBook = bookService.get(2L);
        System.out.println(tomJerryBook);
    }
}


//    public static void main(String[] args) {
//        LiteraryFormatDao literaryFormatDao = new LiteraryFormatDaoImpl();
//        literaryFormatDao.getAll().forEach(System.out::println);
//
//        BookDao bookDao = new BookDaoImpl();
//        Book book = new Book();
//        book.setTittle("Tom&Jerry");
//        book.setPrice(BigDecimal.valueOf(264));
//        book.setFormat(literaryFormatDao.get(5L));
//        bookDao.create(book);
//    }


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
