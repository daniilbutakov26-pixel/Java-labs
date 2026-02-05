package Lab10;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex4_EXEL {

    // Модель строки
    public static class PersonRow {

        @ExcelProperty(index = 0)
        private String name;

        @ExcelProperty(index = 1)
        private Integer age;

        public PersonRow() { }

        public PersonRow(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public Integer getAge() { return age; }
        public void setAge(Integer age) { this.age = age; }

        @Override
        public String toString() {
            return "PersonRow{name='" + name + "', age=" + age + "}";
        }
    }

    // Запись
    public static void writeDemo(Path file, String sheetName) throws IOException {
        validateOutputPath(file);

        List<PersonRow> data = new ArrayList<>();
        data.add(new PersonRow("Иван", 20));
        data.add(new PersonRow("Мария", 22));
        data.add(new PersonRow("Пётр", 19));

        // Открыт ли файл
        try {
            EasyExcel.write(file.toFile(), PersonRow.class)
                    .sheet(sheetName)
                    .doWrite(data);
        } catch (Exception e) {
            throw new IOException(
                    "Не удалось записать файл. " +
                            "Проверьте, не открыт ли файл в Excel и есть ли права на запись.\n" +
                            "Путь: " + file.toAbsolutePath(), e
            );
        }

        System.out.println("Файл записан: " + file.toAbsolutePath());
    }

    // Чтение
    public static void readDemo(Path file, String sheetName) throws IOException {
        validateInputExcelFile(file);

        // Существование листа
        ensureSheetExists(file, sheetName);

        try {
            EasyExcel.read(file.toFile(), PersonRow.class, new AnalysisEventListener<PersonRow>() {
                @Override
                public void invoke(PersonRow row, AnalysisContext context) {
                    System.out.println("Прочитано: " + row);
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext context) {
                    System.out.println("Чтение завершено.");
                }
            }).sheet(sheetName).doRead();

        } catch (Exception e) {
            // runtime-исключения по формату/данным
            throw new IOException(
                    "Ошибка чтения Excel.\n" +
                            "Возможные причины:\n" +
                            "- файл не .xlsx или повреждён\n" +
                            "- структура не соответствует модели (2 столбца: name, age)\n" +
                            "- в колонке age попался текст вместо числа\n" +
                            "Файл: " + file.toAbsolutePath(), e
            );
        }
    }

    // Валидация файла
    private static void validateInputExcelFile(Path file) throws IOException {
        if (file == null) throw new IOException("Путь к файлу не задан.");

        if (!Files.exists(file)) {
            throw new FileNotFoundException("Файл не найден: " + file.toAbsolutePath());
        }
        if (!Files.isRegularFile(file)) {
            throw new IOException("Это не файл: " + file.toAbsolutePath());
        }
        if (!Files.isReadable(file)) {
            throw new IOException("Нет прав на чтение файла: " + file.toAbsolutePath());
        }

        String name = file.getFileName().toString().toLowerCase();
        if (!name.endsWith(".xlsx")) {
            throw new IOException("Неверный формат файла. Нужен .xlsx, получено: " + name);
        }

        long size = Files.size(file);
        if (size == 0) {
            throw new IOException("Файл пустой (0 байт): " + file.toAbsolutePath());
        }
    }

    // Валидация пути
    private static void validateOutputPath(Path file) throws IOException {
        if (file == null) throw new IOException("Путь к файлу не задан.");

        Path parent = file.getParent();
        if (parent != null) Files.createDirectories(parent);

        // Директория доступна для записи
        if (parent != null && (!Files.exists(parent) || !Files.isWritable(parent))) {
            throw new IOException("Нет прав на запись в папку: " + parent.toAbsolutePath());
        }
    }

    //Проверка листа
    private static void ensureSheetExists(Path file, String sheetName) throws IOException {
        // Если лист не задан — пропустим (EasyExcel будет читать первый по умолчанию)
        if (sheetName == null || sheetName.trim().isEmpty()) return;

        try (Workbook wb = WorkbookFactory.create(new File(file.toString()))) {
            Sheet sheet = wb.getSheet(sheetName);
            if (sheet != null) return;

            // Список доступных листов
            StringBuilder available = new StringBuilder();
            for (int i = 0; i < wb.getNumberOfSheets(); i++) {
                available.append("- ").append(wb.getSheetName(i)).append(System.lineSeparator());
            }

            throw new IOException(
                    "Лист \"" + sheetName + "\" не найден.\n" +
                            "Доступные листы:\n" + available
            );

        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new IOException(
                    "Не удалось открыть файл для проверки листов. " +
                            "Возможные причины: файл повреждён или не является .xlsx.\n" +
                            "Файл: " + file.toAbsolutePath(), e
            );
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Path file = Path.of("tmp/lr10/demo.xlsx");
        String sheetName = "Sheet1";

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("0 - записать тестовый Excel");
            System.out.println("1 - прочитать Excel");
            System.out.println("e - выход");
            System.out.print(">>> ");

            String cmd = in.nextLine().trim();

            if (cmd.equalsIgnoreCase("e")) break;

            try {
                switch (cmd) {
                    case "0":
                        writeDemo(file, sheetName);
                        break;

                    case "1":
                        System.out.print("Введите имя листа (Enter = Sheet1): ");
                        String inputSheet = in.nextLine().trim();
                        String useSheet = inputSheet.isEmpty() ? sheetName : inputSheet;

                        readDemo(file, useSheet);
                        break;

                    default:
                        System.out.println("Неизвестная команда.");
                        break;
                }
            } catch (IOException ex) {
                // Подробное сообщение + советы
                System.out.println("\nОшибка: " + ex.getMessage());
                System.out.println("\nРекомендации:");
                System.out.println("- проверьте путь к файлу и расширение .xlsx");
                System.out.println("- закройте файл в Excel, если он открыт");
                System.out.println("- убедитесь, что лист существует (имя без ошибок)");
                System.out.println("- проверьте типы данных: age должно быть числом");

                System.out.print("\nИсправьте проблему и нажмите Enter для повтора (или 'e' для выхода): ");
                String again = in.nextLine().trim();
                if (again.equalsIgnoreCase("e")) break;
            }
        }

        System.out.println("Выход.");
    }
}
