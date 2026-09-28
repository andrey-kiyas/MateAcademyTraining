package MateAcademy.extra;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.epub.EpubParser;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.parser.pdf.PDFParserConfig;
import org.apache.tika.sax.BodyContentHandler;

import java.io.*;
import java.nio.file.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class BookOrganizer {
    public static void main(String[] args) {
        String folderPath = "E:\\Books";
        String csvOutput = "books.csv";
        AtomicInteger count = new AtomicInteger(0);

        // Настройка PDF-парсера: отключаем извлечение текста для мгновенной работы
        PDFParserConfig pdfConfig = new PDFParserConfig();
        pdfConfig.setExtractInlineImages(false);
        pdfConfig.setExtractUniqueInlineImagesOnly(false);

        try (PrintWriter writer = new PrintWriter(new FileWriter(csvOutput));
             Stream<Path> paths = Files.walk(Paths.get(folderPath))) {

            writer.println("FileName;Title;Year;Author");

            paths.filter(Files::isRegularFile)
                    .filter(p -> p.toString().toLowerCase().endsWith(".pdf") || p.toString().toLowerCase().endsWith(".epub"))
                    .forEach(path -> {
                        File file = path.toFile();
                        int currentNum = count.incrementAndGet();
                        System.out.println("[" + currentNum + "] Обработка: " + file.getName());

                        Metadata metadata = new Metadata();
                        ParseContext context = new ParseContext();
                        String fileNameLower = file.getName().toLowerCase();

                        Parser parser;
                        if (fileNameLower.endsWith(".pdf")) {
                            parser = new PDFParser();
                            context.set(PDFParserConfig.class, pdfConfig);
                        } else {
                            parser = new EpubParser();
                        }

                        try (InputStream is = new FileInputStream(file)) {
                            // -1 отключает лимит на символы, а BodyContentHandler игнорирует текст
                            parser.parse(is, new BodyContentHandler(-1), metadata, context);

                            String title = metadata.get("dc:title") != null ? metadata.get("dc:title") : file.getName();
                            String year = metadata.get("dc:date") != null ? metadata.get("dc:date") : "Unknown";
                            String author = metadata.get("dc:creator") != null ? metadata.get("dc:creator") : "Unknown";

                            title = title.replaceAll(";", " ").replaceAll("[\r\n]+", " ");
                            author = author.replaceAll(";", " ").replaceAll("[\r\n]+", " ");

                            writer.printf("%s;%s;%s;%s%n", file.getName(), title, year, author);
                        } catch (Throwable e) {
                            System.err.println("Ошибка чтения: " + file.getName() + " -> " + e.getMessage());
                            writer.printf("%s;Error reading metadata;Unknown;Unknown%n", file.getName());
                        }
                    });

            System.out.println("Готово! Список сохранен в " + csvOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}